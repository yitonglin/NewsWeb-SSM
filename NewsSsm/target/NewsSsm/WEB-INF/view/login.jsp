<%--
  Created by IntelliJ IDEA.
  User: yiton
  Date: 2020/6/25
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>微新闻</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" type="text/css" href="${ctx}/resource/res/layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/resource/res/static/css/main.css">
</head>
<body class="micronews micronews-login">

<div class="micronews-login-container">
  <div class="form-box">
    <h3>登录</h3>
    <div class="wrap">
      <form class="layui-form" action=""> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
        <div class="layui-form-item">
          <div class="layui-input-block">
            <input  type="text" name="username" lay-verify="required" id="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <input type="password" name="password" lay-verify="required" id="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <input type="text"  name="code" lay-verify="required" id="code" placeholder="请输入验证码" autocomplete="off" class="layui-input">
            <img src="${ctx}/user/getCode.action" onclick="this.src=this.src+'?'">
          </div>
        </div>
        <div class="layui-form-item agreement">
          <div class="layui-input-block">
            <input id="checkbox" type="checkbox" name="like1[write]" lay-verify="required" lay-skin="primary" title="我已阅读并同意" checked="">
            <span class="txt"><a id="agreement" href="#">用户协议</a>和<a  href="#" id="privacy">隐私条款</a></span>
          </div>

        </div>

        <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
      </form>

      <div class="layui-form-item">
        <div class="layui-input-block">
          <button id="log" class="layui-btn" lay-submit >登录</button>
        </div>
      </div>
    </div>


  </div>
</div>

<script type="text/javascript" src="${ctx}/resource/res/layui/layui.js"></script>
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script>
  layui.config({
    base: '${ctx}/resource/res/static/js/'
  }).use('index',function(){
    var index = layui.index;
    var $=layui.$
    index.seachBtn()
    index.login()
    index.arrowutil()


    //登陆验证
   $('#log').on('click',function () {
      if ($("#checkbox").get(0).checked) {
        $.get("${ctx}/user/login.action?username="+$("#username").val()+"&password="+$("#password").val()+"&code="+$("#code").val(),function (data) {
          if(data=="index"){

            window.location.href = "${ctx}/user/index.action";
          }else if (data=="errorName"){
            // $('#errorMessage').textContent="用户名或者密码错误！";
            layer.msg("用户名或者密码错误！")
          }else if (data=="errorCode"){
            layer.msg("验证码错误！")
          }else if(data=="errorActive"){
            layer.msg("用户还为邮箱激活！")
          }
        })
      }else{
        layer.msg("请同意用户协议和隐私")
      }
    })

    //监听用户协议
    $('#agreement').on("click",function () {
      var layer = layui.layer;
      layer.open({
        type:2,
        area: ['550px', '265px'],
        title:'用户协议',
        content:'${ctx}/user/agreement.action',

      });
    })

    //监听隐私条款
    $('#privacy').on("click",function () {
      var layer = layui.layer;
      layer.open({
        type:2,
        area: ['550px', '265px'],
        title:'隐私条款',
        content:'${ctx}/user/privacy.action',
      });
    })









  });
</script>
</body>
</html>