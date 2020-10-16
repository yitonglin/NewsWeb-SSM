package com.news.lyt.controller;

import com.news.lyt.domain.*;
import com.news.lyt.service.MySelfService;
import com.news.lyt.utils.WebUtils;
import com.news.lyt.utils.ZXingCodeDecodeUtils;
import com.news.lyt.utils.ZXingCodeEncodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


@Controller
@RequestMapping("/myself")
public class MySelfController {

    @Autowired
    private MySelfService mySelfService;


    //登出
    @RequestMapping("unLogin")
    public String unLogin(){
        WebUtils.getHttpSession().removeAttribute("user");
        return "index";
    }


    //查看个人信息
    @ResponseBody
    @RequestMapping("lookMyself")
    public User lookMyself(){
        User user1 = (User) WebUtils.getHttpSession().getAttribute("user");
        String username = user1.getUsername();
        User user = new User();
        user = mySelfService.lookMyself(username);
        String password = user.getPassword();

        return user;
    }

    //分页查询个人评论
    @ResponseBody
    @RequestMapping("lookMyselfComments")
    public List<MyCommentsVo> lookMyselfComments(int page){
         /**
         *         1：根据用户名查询出用户id和头像地址（此处头像在后面循环放入MyCommentsVo中）
         *         2: 根据用户id=uid查询出Comments中所有得评论信息
         *         3：根据所有评论信息中得到得新闻id-->nid查询文章信息
         *         4：循环放如MyCommentsVo中
         */
        List<MyCommentsVo> myCommentsVos = new ArrayList<>();

        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        String username = user.getUsername();
        //封装查询出的id和头像地址
        UserIdAndPhoto userIdAndPhoto = new UserIdAndPhoto();
        userIdAndPhoto = mySelfService.findUserIdAndPhoto(username);
        //查询分页评论
        page = (page-1)*6;//分页查询的开始位置
        int uid = userIdAndPhoto.getId();//根据用户id查询评论
        myCommentsVos = mySelfService.lookMyselfComments(page,uid);
        News news = new News();
        //循环根据nid查询分类id再判断
        List<MyCommentsVo> myCommentsVos1 = new ArrayList<>();
        for (MyCommentsVo miter : myCommentsVos) {
            MyCommentsVo m = new MyCommentsVo();
            m.setContent(miter.getContent());//评论内容
            m.setCommentstime(miter.getCommentstime());//评论时间
            m.setPhoto(userIdAndPhoto.getPhoto());//头像
            m.setUsername(username);
            //根据nid查询文章信息
            int nid = miter.getNid();
            news = mySelfService.findNewsByNid(nid);
            m.setTitle(news.getNewsname());//文章标题
            //文章分类
            if (news.getCid()==1){
                m.setCategory("娱乐");
            }
            if (news.getCid()==2){
                m.setCategory("生活");
            }
            if (news.getCid()==3){
                m.setCategory("财经");
            }
            if (news.getCid()==4){
                m.setCategory("科技");
            }
            if (news.getCid()==5){
                m.setCategory("军事");
            }
            //回复数量
            m.setReplynum(news.getReplynum());
            //文章时间
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeStr = format.format(news.getTime());
            m.setNtime(timeStr);
            myCommentsVos1.add(m);
        }
        return myCommentsVos1;
    }


    //修改个人信息
    @ResponseBody
    @RequestMapping("reMyself")
    public void reMyself(User user){
        String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pwd);
        WebUtils.getHttpSession().setAttribute("user",user);
        mySelfService.reMyself(user);
    }

    //查询个人评论数量
    @ResponseBody
    @RequestMapping("lookMyselfCommentsNum")
    public int lookMyselfCommentsNum(){
        int count;
        User user1 = (User) WebUtils.getHttpSession().getAttribute("user");
        String username =  user1.getUsername();
        //查询用户信息
        User user = mySelfService.lookMyself(username);
        int id = user.getId();//用户id
        //根据用户id查询此用户下得所有评论数量
        count = mySelfService.myComments(id);
        return count;
    }

      /**
     * 不下载只显示
     */
    @RequestMapping("downloadShowFile")
    public void downloadShowFile(String path, HttpServletResponse response,String status) throws IOException {
        if (status.equals("1")) {
            if(!path.equals("null")){
                FileInputStream fis = new FileInputStream(path);
                BufferedImage image = ImageIO.read(fis);
                ServletOutputStream outputStream = response.getOutputStream();
                ImageIO.write(image, "JPEG", outputStream);
            }else{
                //System.out.println("============================"+path);
                InputStream stream = MySelfController.class.getClassLoader().getResourceAsStream("header.png");
                BufferedImage bufferedImage=new BufferedImage(28,28,BufferedImage.TYPE_INT_RGB);
                Graphics graphics=bufferedImage.getGraphics();
                //读取原始位图
                Image srcImage= ImageIO.read(stream);
                //将原始位图缩小后绘制到bufferedImage对象中
                graphics.drawImage(srcImage.getScaledInstance(28, 28, Image.SCALE_SMOOTH), 0, 0, null);
                ServletOutputStream outputStream = response.getOutputStream();
                ImageIO.write(bufferedImage, "JPEG", outputStream);
            }
        } else {
            FileInputStream fis = new FileInputStream("D:\\news\\headPhoto\\" + path);
            BufferedImage image = ImageIO.read(fis);
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(image, "JPEG", outputStream);
        }
    }




       //显示评论头像
    @RequestMapping("headphoto")
    public void downloadFile(HttpServletResponse response) throws IOException {
        //首先判断是否登录了，没登录显示的小猫
        if(WebUtils.getHttpSession().getAttribute("user")!=null){
            User user=(User)WebUtils.getHttpSession().getAttribute("user");
            String head=mySelfService.findhead(user);

            InputStream stream = MySelfController.class.getClassLoader().getResourceAsStream("header.png");

            System.out.println(head+"=================================");
            //读取原始位图
            if(!head.equals("null")){
                FileInputStream fis=new FileInputStream(head);
                BufferedImage image= ImageIO.read(fis);

                ServletOutputStream outputStream = response.getOutputStream();
                ImageIO.write(image, "JPEG", outputStream);
            }else{
                BufferedImage bufferedImage=new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
                Graphics graphics=bufferedImage.getGraphics();
                //读取原始位图
                Image srcImage= ImageIO.read(stream);
                //将原始位图缩小后绘制到bufferedImage对象中
                graphics.drawImage(srcImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH), 0, 0, null);
                ServletOutputStream outputStream = response.getOutputStream();
                ImageIO.write(bufferedImage, "JPEG", outputStream);
            }

        }else {
            InputStream stream = NewsController.class.getClassLoader().getResourceAsStream("header.png");
            BufferedImage bufferedImage=new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
            Graphics graphics=bufferedImage.getGraphics();
            //读取原始位图
            Image srcImage= ImageIO.read(stream);
            //将原始位图缩小后绘制到bufferedImage对象中
            graphics.drawImage(srcImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH), 0, 0, null);
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "JPEG", outputStream);
        }
    }


    @RequestMapping("uploadFile")
    @ResponseBody
    public Map<String,Object> uploadFile(MultipartFile mf) throws IOException {
        // 文件上传的父目录
        String parentPath = "D:\\news\\headPhoto\\";
        // 得到当前用户名作为名称
        User user=(User)WebUtils.getHttpSession().getAttribute("user");
        String dirName =String.valueOf(user.getId());
        // 构造文件夹对象
        File dirFile = new File(parentPath, dirName);
        if (!dirFile.exists()) {
            dirFile.mkdirs();// 创建文件夹
        }
        // 根据文件原名得到新名
        String suffix  = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf(".") + 1);
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String newName =user.getUsername()+sdf1.format(new Date());
        File dest = new File(dirFile, newName+"."+suffix);

        deleteFile(dirFile);	//调用删除文件方法
        //文件夹被删除了重新创建
//        File dirFile1 = new File(parentPath, dirName);
//        if (!dirFile1.exists()) {
//            dirFile1.mkdirs();// 创建文件夹
//        }
        //写文件
        mf.transferTo(dest);
        //返回json
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        Map<String,Object> data=new HashMap<>();
        data.put("src", dirName+"\\"+newName+"."+suffix);
        map.put("data",data);

        return map;

    }
    //递归删除
    public void deleteFile(File file){
        if (file.exists()) {    		//测试文件或目录是否存在，存在进入下一步
            if (file.isFile()) {
                boolean result = file.delete();
                if(!result)
                {
                    System.gc();
                    file.delete();
                }//判断file 是不是文件，如果是直接删除
                else {
                    return;
                }
            }else{			//如果不是，则一定是文件夹
                File[] files = file.listFiles();		//获取文件夹下的file对象列表
                if (files.length==0) {					//判断此文件夹下有没有文件或目录
                    return;							//没有的话，直接删除此路径，有的话，遍历此路径，重复以上动作
                }else{
                    for (File file1 : files) {
                        deleteFile(file1);
                    }
                    return;				//文件夹下所有文件和目录均被清空，删除本文件夹
                }
            }

        }else{
            System.out.println("文件或目录不存在");
        }
    }
    /*收藏数量*/
    @ResponseBody
    @RequestMapping("lookMyselfCollectionNum")
    public int lookMyselfCollectionNum(){
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        int userId=user.getId();
        int countNum = mySelfService.lookMyselfCollectionNum(userId);
        return countNum;
    }
    //收藏查询
    @ResponseBody
    @RequestMapping("lookMyselfCollection")
    public List<CollectionVo> lookMyselfCollection(int page){
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        int userId=user.getId();
        page=6*(page-1);
        List<CollectionVo> list=mySelfService.lookMyselfCollection(userId,page);
        return list;
    }

    //二维码生成
    @RequestMapping("encode")
    public void encode(HttpServletResponse response) throws IOException {
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        User user1=mySelfService.lookMyself(user.getUsername());
        if(!user1.getPhoto().equals("null")){
            FileInputStream logoStream=new FileInputStream(user1.getPhoto());
            String conent="  这是我的二维码名片,我的用户名："+user1.getUsername()+",我的MD5加密密码："+user1.getPassword()+",我的邮箱："+user1.getEmail()+",我的邮箱验证状态：已通过验证";

            BufferedImage codeImage= ZXingCodeEncodeUtils.createZxingCodeUseLogo(conent, 300, 300, logoStream);
            //写在网页
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(codeImage, "JPEG", outputStream);
            outputStream.close();
        }else{
            InputStream stream = NewsController.class.getClassLoader().getResourceAsStream("header.png");
            String conent="  这是我的二维码名片，我的用户名："+user1.getUsername()+"，我的MD5加密密码："+user1.getPassword()+"，我的邮箱："+user1.getEmail()+"，我的邮箱验证状态：已通过验证";

            BufferedImage codeImage= ZXingCodeEncodeUtils.createZxingCodeUseLogo(conent, 300, 300, stream);
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(codeImage, "JPEG", outputStream);
            outputStream.close();
        }

    }
    //二维码解析
    @RequestMapping("decode")
    @ResponseBody
    public Map<String,Object> decode(MultipartFile mf) throws IOException {
        //调用解析二维码的类
        String string = ZXingCodeDecodeUtils.decodeCodeStream(mf.getInputStream());
        Map<String,Object> map=new HashMap<>();
        map.put("cont",string);
        return map;
    }

    //导出二维码
    @RequestMapping("exportZxing")
    public ResponseEntity<Object> exportZxing(HttpServletResponse response) throws IOException {

        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        User user1=mySelfService.lookMyself(user.getUsername());
        if(!user1.getPhoto().equals("null")){
            FileInputStream logoStream=new FileInputStream(user1.getPhoto());
            String conent="  这是我的二维码名片，我的用户名："+user1.getUsername()+"，我的MD5加密密码："+user1.getPassword()+"，我的邮箱："+user1.getEmail()+"，我的邮箱验证状态：已通过验证";

            BufferedImage codeImage= ZXingCodeEncodeUtils.createZxingCodeUseLogo(conent, 300, 300, logoStream);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                ImageIO.write(codeImage, "JPEG", out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileName=user1.getUsername()+"的二维码名片.jpg";
            try {
                System.out.println("=================================================================");
                fileName= URLEncoder.encode(fileName,"UTF-8");//处理文件名乱码
                //创建封装响应头信息的对象
                HttpHeaders header=new HttpHeaders();
                //封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
                header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                //设置下载的文件的名称,"attachment"是固定写法
                header.setContentDispositionFormData("attachment", fileName);
                return new ResponseEntity<Object>(out.toByteArray(), header, HttpStatus.CREATED);
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            InputStream stream = NewsController.class.getClassLoader().getResourceAsStream("header.png");
            String conent="  这是我的二维码名片，我的用户名："+user1.getUsername()+"，我的MD5加密密码："+user1.getPassword()+"，我的邮箱："+user1.getEmail()+"，我的邮箱验证状态：已通过验证";

            BufferedImage codeImage= ZXingCodeEncodeUtils.createZxingCodeUseLogo(conent, 300, 300, stream);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                ImageIO.write(codeImage, "JPEG", out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileName=user1.getUsername()+"的二维码名片.jpg";
            try {
                System.out.println("=================================================================");
                fileName= URLEncoder.encode(fileName,"UTF-8");//处理文件名乱码
                //创建封装响应头信息的对象
                HttpHeaders header=new HttpHeaders();
                //封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
                header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                //设置下载的文件的名称,"attachment"是固定写法
                header.setContentDispositionFormData("attachment", fileName);
                return new ResponseEntity<Object>(out.toByteArray(), header, HttpStatus.CREATED);
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       return null;
    }
}
