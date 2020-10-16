package com.news.lyt.controller;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import	java.lang.ProcessBuilder.Redirect;

import com.news.lyt.domain.*;
import com.news.lyt.service.INewsService;
import com.news.lyt.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;


    @ResponseBody
    @RequestMapping("newsPage")
    public List<NewsNum> NewsPage(){
        List<News> listNews = new ArrayList<>();
        List<NewsNum> listNewsNums = new ArrayList<>();
        //NewsNum newsNum = new NewsNum();
        listNews = newsService.newsPage();
        //将后天查询到的数据重新封装到NewNum
        for (News listNew : listNews) {
            NewsNum newsNum = new NewsNum();//此处为防止add时覆盖的问题
            newsNum.setImg(listNew.getPhotoaddress());
            newsNum.setTitle(listNew.getNewsname());
            //根据cid设置分类
            if (listNew.getCid()==1){
                newsNum.setLabel("娱乐");
            }
            if (listNew.getCid()==2){
                newsNum.setLabel("生活");
            }
            if (listNew.getCid()==3){
                newsNum.setLabel("财经");
            }
            if (listNew.getCid()==4){
                newsNum.setLabel("科技");
            }
            if (listNew.getCid()==5){
                newsNum.setLabel("军事");
            }
            newsNum.setMessage(listNew.getReplynum());
            //newsNum.setTime(listNew.getTime());
            SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            newsNum.setTime(format0.format(listNew.getTime()));//这个就是把时间戳经过处理得到期望格式的时间

            listNewsNums.add(newsNum);
        }
        return listNewsNums;
    }









    //轮播图查询
    @ResponseBody
    @RequestMapping("takePhotos")
    public List<TakePhtoco> takePhotos(int categoryPhoto){
        List<TakePhtoco> takePhtocos = new ArrayList<>();//查询后返回的封装处
        takePhtocos = newsService.takePhotos(categoryPhoto);
        return takePhtocos;
    }


    //这里是判断头像的
    @ResponseBody
    @RequestMapping("photo")
    public String photo(){
        if(WebUtils.getHttpSession().getAttribute("user")!=null){
            return "user";
        }
        return "nouser";
    }



    //文章详情
    @ResponseBody
    @RequestMapping("details")
    public DetailsVo details() throws IOException {
        DetailsVo detailsVo = new DetailsVo();

        String title = (String) WebUtils.getHttpSession().getAttribute("title");
        //String title = "未来十年，中国将出现三家世界级芯片企业";
        News news = newsService.details(title);

        detailsVo.setTitle(title);
        if (news.getCid()==1){
            detailsVo.setCategory("娱乐");
        }
        if (news.getCid()==2){
            detailsVo.setCategory("生活");
        }
        if (news.getCid()==3){
            detailsVo.setCategory("财经");
        }
        if (news.getCid()==4){
            detailsVo.setCategory("科技");
        }
        if (news.getCid()==5){
            detailsVo.setCategory("军事");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        detailsVo.setTimeStr(format.format(news.getTime()));
        detailsVo.setTitle(title);
        detailsVo.setLookNum(news.getLooknum());
        detailsVo.setReplyNum(news.getReplynum());
        detailsVo.setPhoto(news.getPhotoaddress());
        //读取文本
        List<String> list = new ArrayList<String>();
        String encoding = "UTF-8";
        File file = new File(news.getTextaddress());
        InputStreamReader read = new InputStreamReader(
                new FileInputStream(file), encoding);// 考虑到编码格式
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        while ((lineTxt = bufferedReader.readLine()) != null)
        {
            list.add(lineTxt);
        }
        bufferedReader.close();
        read.close();
        detailsVo.setText(list);
        return detailsVo;
    }



    //新闻页评论
    @ResponseBody
    @RequestMapping("commens")
    public List<CommentsVo> commens(){
        //String title = "未来十年，中国将出现三家世界级芯片企业";
        List<CommentsVo> commentsVo =  new ArrayList<>();//最后返回list
        String title = (String) WebUtils.getHttpSession().getAttribute("title");
        News news = newsService.commens(title);
        //根据新闻的id查询本新闻下的所有评论
        int nid = news.getId();
        //查询一共多少条评论数据
        int limitNum = newsService.idByNum(nid);
        NidById nidById = new NidById();
        nidById.setNid(nid);
        nidById.setLimitNum(limitNum);

        List<Comments> comments = newsService.nidByid(nidById);
        for (Comments comments1 : comments) {
            int uid = comments1.getUid();
            //存储数据库中查询得用户名和头像地址
            UsernameAndPhoto usernameAndPhoto = new UsernameAndPhoto();
            usernameAndPhoto = newsService.uidByUsername(uid);//使用uid查询用户名

            //封装返回的list数据
            CommentsVo commentsVo1 = new CommentsVo();
            commentsVo1.setUsername(usernameAndPhoto.getUsername());
            commentsVo1.setPhoto(usernameAndPhoto.getPhoto());
            commentsVo1.setUid(uid);
            commentsVo1.setText(comments1.getContent());
            SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            commentsVo1.setTime(format0.format(comments1.getCommentstime()));
            commentsVo.add(commentsVo1);

        }
        return commentsVo;
    }





    //这里是个人中心
    @RequestMapping("perslnfo")
    public String perslnfo(){
        return "persInfo";
    }


    //这里是检索页面
    @RequestMapping("search")
    public String search(String title){
       // WebUtils.getHttpSession().removeAttribute("search");
        WebUtils.getHttpSession().setAttribute("search",title);
        return "search";
    }

    //这里是检索渲染数据页面
    @ResponseBody
    @RequestMapping("searchnews")
    public PageVo searchnews() throws IOException {
        String title= WebUtils.getHttpSession().getAttribute("search").toString();
        // 查询session的查询标题的内容代码
        List<News> news=new ArrayList<>();
        news = newsService.searchnews('%'+title+'%');
        int count = news.size();
        List<NewsSerach> newsSearches = new ArrayList<> ();
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //newsNum.setTime(format0.format(listNew.getTime()));//这个就是把时间戳经过处理得到期望格式的时间
        for (News news1 : news) {
            NewsSerach newsSearch1 = new NewsSerach();
            newsSearch1.setTime(format0.format(news1.getTime()));
            newsSearch1.setLooknum(news1.getLooknum());
            newsSearch1.setNewsname(news1.getNewsname());
            String address = news1.getTextaddress();

            //使用IO流读取第一行数据
            FileReader fileReader = new FileReader(address);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(address),"UTF-8"));
            //BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line =bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
            System.out.println("------"+line);

            newsSearch1.setText(line);
            newsSearches.add(newsSearch1);
        }
        PageVo pageVo = new PageVo();
        pageVo.setListNews(newsSearches);
        pageVo.setCountNum(count);
        return pageVo;
    }

    //热门资讯
    @ResponseBody
    @RequestMapping("hotNews")
    public List<String> hotNews(){
        //接受处理数据库返回后的数据
        List<News> hotListNews = new ArrayList<>();
        //根据页面要求封装数据，返回到页面上
        List<String> hotListPageNews = new ArrayList<>();
        //进行请求数据库数据
        hotListNews = newsService.hotNews();
        //处理数据
        for (News hotNew : hotListNews) {
            hotListPageNews.add(hotNew.getNewsname());
        }
        return hotListPageNews;
    }

    //显示新闻图片的
    @RequestMapping("newsPhoto")
    public void newsPhoto(HttpServletResponse response, HttpSession session, int flag) throws IOException {
        // 搜索图片的本地地址
        List<News> listNews = new ArrayList<>();
        listNews = newsService.newsPage();
        String adress=listNews.get(flag).getPhotoaddress();
        FileInputStream fis=new FileInputStream(adress);
        BufferedImage image= ImageIO.read(fis);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "JPEG", outputStream);
    }


    //这里是娱乐页面
    @RequestMapping("entertainment")
    public String entertainment(){
        return "entertainment";
    }
    //这里是生活页面
    @RequestMapping("life")
    public String life(){
        return "life";
    }
    //这里是财经页面
    @RequestMapping("money")
    public String money(){
        return "money";
    }
    //这里是科技页面
    @RequestMapping("technology")
    public String technology(){
        return "technology";
    }
    //这里是军事页面
    @RequestMapping("military")
    public String military(){
        return "military";
    }

     //显示评论头像
    @RequestMapping("headphoto")
    public void downloadFile(HttpServletResponse response,int status,String address) throws IOException {
    //首先判断是否登录了，没登录显示的小猫
        String photo = address;
        if( status==1){
            if(WebUtils.getHttpSession().getAttribute("user")!=null){
                User user=(User)WebUtils.getHttpSession().getAttribute("user");
                String head=newsService.findhead(user);

                InputStream stream = NewsController.class.getClassLoader().getResourceAsStream("header.png");


                //读取原始位图
                if(!"null".equals(head)){
                    FileInputStream fis=new FileInputStream(head);
                    BufferedImage image= ImageIO.read(fis);
                    //将原始位图缩小后绘制到bufferedImage对象中
                    ServletOutputStream outputStream = response.getOutputStream();
                    ImageIO.write(image, "JPEG", outputStream);
                }else{
                    BufferedImage bufferedImage=new BufferedImage(28,28,BufferedImage.TYPE_INT_RGB);
                    Graphics graphics=bufferedImage.getGraphics();
                    //读取原始位图
                    Image srcImage= ImageIO.read(stream);
                    //将原始位图缩小后绘制到bufferedImage对象中
                    graphics.drawImage(srcImage.getScaledInstance(28, 28, Image.SCALE_SMOOTH), 0, 0, null);
                    ServletOutputStream outputStream = response.getOutputStream();
                    ImageIO.write(bufferedImage, "JPEG", outputStream);
                }

            }else {
                InputStream stream = NewsController.class.getClassLoader().getResourceAsStream("header.png");
                BufferedImage bufferedImage=new BufferedImage(28,28,BufferedImage.TYPE_INT_RGB);
                Graphics graphics=bufferedImage.getGraphics();
                //读取原始位图
                Image srcImage= ImageIO.read(stream);
                //将原始位图缩小后绘制到bufferedImage对象中
                graphics.drawImage(srcImage.getScaledInstance(28, 28, Image.SCALE_SMOOTH), 0, 0, null);
                ServletOutputStream outputStream = response.getOutputStream();
                ImageIO.write(bufferedImage, "JPEG", outputStream);
            }
        }else if(status==2){

            if(!address.equals("null")){
                System.out.println(address+"========================");
                FileInputStream fis=new FileInputStream(address);
                BufferedImage image= ImageIO.read(fis);
                //将原始位图缩小后绘制到bufferedImage对象中
                ServletOutputStream outputStream = response.getOutputStream();
                ImageIO.write(image, "JPEG", outputStream);
            }else {

                InputStream stream = NewsController.class.getClassLoader().getResourceAsStream("header.png");
                BufferedImage bufferedImage=new BufferedImage(28,28,BufferedImage.TYPE_INT_RGB);
                Graphics graphics=bufferedImage.getGraphics();
                //读取原始位图
                Image srcImage= ImageIO.read(stream);
                //将原始位图缩小后绘制到bufferedImage对象中
                graphics.drawImage(srcImage,0,0,28,28,null);
                ServletOutputStream outputStream = response.getOutputStream();
                ImageIO.write(bufferedImage, "JPEG", outputStream);

            }
        }else{
            User user=(User)WebUtils.getHttpSession().getAttribute("user");
            String address1=newsService.findhead(user);
            if(!address1.equals("null")){
                FileInputStream fis=new FileInputStream(address1);
                BufferedImage image= ImageIO.read(fis);
                //将原始位图缩小后绘制到bufferedImage对象中
                ServletOutputStream outputStream = response.getOutputStream();
                ImageIO.write(image, "JPEG", outputStream);
            }else{
                InputStream stream = NewsController.class.getClassLoader().getResourceAsStream("header.png");
                BufferedImage bufferedImage=new BufferedImage(28,28,BufferedImage.TYPE_INT_RGB);
                Graphics graphics=bufferedImage.getGraphics();
                //读取原始位图
                Image srcImage= ImageIO.read(stream);
                //将原始位图缩小后绘制到bufferedImage对象中
                graphics.drawImage(srcImage,0,0,28,28,null);
                ServletOutputStream outputStream = response.getOutputStream();
                ImageIO.write(bufferedImage, "JPEG", outputStream);
            }
        }
    }

    //监听评论发表
    @RequestMapping("inconmments")
    public void conmments(String text){
        String title = (String) WebUtils.getHttpSession().getAttribute("title");
        Integer nid=newsService.findnid(title);
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        Integer uid=newsService.finduid(user.getUsername());
        CommentsVoSave commentsVo=new CommentsVoSave();
        commentsVo.setContent(text);
        commentsVo.setNid(nid);
        commentsVo.setUid(uid);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        commentsVo.setCommentstime(df.format(new Date()));// new Date()为获取当前系统时间
        newsService.insertcomments(commentsVo);
        //新闻页评论加一
        newsService.addOneReply(nid);

    }


    //idnex跳转到详情界面用于重新请求详情
    @RequestMapping("detailsPage")
    public String detailsPage(String title){
        WebUtils.getHttpSession().setAttribute("title",title);
        //增加文章阅读次数
        newsService.addLookNum(title);

        return "details";
    }


     //这里是分类博文页面热门资讯的处理
    @ResponseBody
    @RequestMapping("categoryHotNews")
    public List<String> categoryHotNews(String active) {
        int activeInt = 0;
        if ("娱乐".equals(active)) {
            activeInt = 1;
        } else if ("生活".equals(active)) {
            activeInt = 2;
        } else if ("财经".equals(active)) {
            activeInt = 3;
        } else if ("科技".equals(active)) {
            activeInt = 4;
        } else if ("军事".equals(active)) {
            activeInt = 5;
        }
        //接受处理数据库返回后的数据
        List<News> categoryHotListNews;
        //根据页面要求封装数据，返回到页面上
        List<String> hotListPageNews = new ArrayList<>();
        //进行请求数据库数据
        categoryHotListNews = newsService.categoryHotNews(activeInt);
        //处理数据
        for (News hotNew : categoryHotListNews) {
            hotListPageNews.add(hotNew.getNewsname());
        }
        return hotListPageNews;
}



    @RequestMapping("categoryNewsPhoto")
    public void categoryNewsPhoto(HttpServletResponse response, String address) throws IOException {
        // 搜索图片的本地地址
        FileInputStream fis = new FileInputStream(address);
        BufferedImage image = ImageIO.read(fis);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "JPEG", outputStream);
    }


    @ResponseBody
    @RequestMapping("categoryPage")
    public List<NewsNum> categoryPage(String active) {
        //接受数据库的查询数据
        List<News> listNews = new ArrayList<>();
        //封装页面查询到的数据
        List<NewsNum> listNewsNums = new ArrayList<>();
        int activeInt = 0;
        if ("娱乐".equals(active)) {
            activeInt = 1;
        } else if ("生活".equals(active)) {
            activeInt = 2;
        } else if ("财经".equals(active)) {
            activeInt = 3;
        } else if ("科技".equals(active)) {
            activeInt = 4;
        } else if ("军事".equals(active)) {
            activeInt = 5;
        }
        //数据库数据查询
        listNews = newsService.categoryPage(activeInt);

        //将后台查询到的数据重新封装到NewNum
        for (News listNew : listNews) {
            NewsNum newsNum = new NewsNum();//此处为防止add时覆盖的问题
            newsNum.setImg(listNew.getPhotoaddress());
            newsNum.setTitle(listNew.getNewsname());
            newsNum.setLabel(active);
            newsNum.setMessage(listNew.getReplynum());
            SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            newsNum.setTime(format0.format(listNew.getTime()));//这个就是把时间戳经过处理得到期望格式的时间
            listNewsNums.add(newsNum);
        }
        return listNewsNums;
    }

    //收藏：collection.action (后台需接收title，以及取消收藏标识 0取消收藏，1收藏)
    @RequestMapping("collection")
    public void collection(int flag){
        //通过session获取用户id
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        String title=(String) WebUtils.getHttpSession().getAttribute("title");
        //通过user获取id号
        int userId=user.getId();
        //获取博客id
        int newsId=newsService.searchNewsId(title);
        System.out.println("============================="+userId+"==============="+newsId+"============"+flag);
        //根据标号设置收藏和取消收藏
        if (flag==1){
            //设置收藏，插入comments表
            newsService.insertCollection(userId,newsId);
        }else{
            //收藏的id，根据userID和newsId查询收藏id，之后删除收藏id
            newsService.deleteCollection(userId,newsId);
        }
    }

    @ResponseBody
    @RequestMapping("collectionop")
    public int collectionop(){
        //通过session获取用户id
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        if(user!=null){
            String title=(String) WebUtils.getHttpSession().getAttribute("title");
            //通过user获取id号
            int userId=user.getId();
            //获取博客id
            int newsId=newsService.searchNewsId(title);
            int flag=newsService.collectionop(userId,newsId);
            System.out.println("********************"+flag);
            return flag;
        }
        int flag=0;
        return flag;
    }



}
