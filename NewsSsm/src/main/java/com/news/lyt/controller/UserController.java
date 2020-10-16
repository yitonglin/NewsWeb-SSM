package com.news.lyt.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.news.lyt.domain.EmailActive;
import com.news.lyt.domain.User;
import com.news.lyt.service.IUserService;
import com.news.lyt.service.impl.UserServiceImpl;
import com.news.lyt.utils.MailUtils;
import com.news.lyt.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    //监听用户名是否被重复注册
    @ResponseBody
    @RequestMapping("finduser")
    public int finduser(String username){
        User user1 =  userService.findUser(username);
        if (null!=user1){
            //user对象放到session域中
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 主页登录界面跳转
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }


    @ResponseBody
    @RequestMapping("login")
    public String login(User user, Model model){
        String code= WebUtils.getHttpSession().getAttribute("code").toString();
            if(user.getCode().equals(code)) {
                User user1 =  userService.login(user);
            if (null!=user1){
                //user对象放到session域中
                if (user1.getStatus()==1){
                    WebUtils.getHttpSession().setAttribute("user",user1);
                    return "index";
                }else{
                    return "errorActive";
                }

            }else{
                //登录用户不存在继续跳转登录页面
                return "errorName";
            }
        }else {
            //验证码失败继续跳转登录页面
                return "errorCode";
        }
    }

    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        // 定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36,4,5);
        session.setAttribute("code", lineCaptcha.getCode());
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(lineCaptcha.getImage(), "JPEG", outputStream);
    }



    /**
     * 首页跳转
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    /**
     * 激活成功后跳转登录界面
     * @return
     */
    @RequestMapping("emailActiveLogin")
    public String emailActiveLogin() {
        return "login";
    }

    /**
     * 注册界面跳转
     * @return
     */
    @RequestMapping("registerView")
    public String registerView() {
        return "register";
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("register")
    public void register(User user){
        String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pwd);
        user.setPhoto("null");
        userService.register(user);
        //3,激活邮件发送，邮件正文
        String email = user.getEmail();
        String username = user.getUsername();
        String content ="<a href='http://127.0.0.1:8080/user/emailActive.action?status=1&emailAddress="+email+"+&username="+username+"'>点击激活【NOVEL IDEAS新闻网】</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        //return "login";
    }

    /**
     * 用户协议跳转
     * @return
     */
    @RequestMapping("agreement")
    public String agreement() {
        return "agreement";
    }
 /**
     * 隐私条款跳转
     * @return
     */
    @RequestMapping("privacy")
    public String privacy() {
        return "privacy";
    }


    /**
     *
     * 邮箱激活
     * @param
     * @return
     */
    @RequestMapping("emailActive")
    public String emailActive(int status,String emailAddress,String username){
        //封装激活邮件的信息（邮箱，状态码）
        EmailActive emailActive = new EmailActive();
        if (status == 1){
            emailActive.setStatus(status);
            emailActive.setEmailAddress(emailAddress);
            emailActive.setUsername(username);
            userService.active(emailActive);
            return "emailActive";
        }else {
            return "failEmailActive";
        }

    }



}
