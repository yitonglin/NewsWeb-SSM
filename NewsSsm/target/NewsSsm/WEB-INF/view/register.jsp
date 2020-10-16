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
      <h3>注册</h3>
      <div class="wrap">
        <form class="layui-form" action="#"> <!-- ${ctx}/user/register.action提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
          <div class="layui-form-item">
            <div class="layui-input-block">
              <input type="text" name="username" lay-verify="required" id="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-form-item">
            <div class="layui-input-block">
              <input type="password"  name="password" lay-verify="required" id="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-form-item">
            <div class="layui-input-block">
              <input type="password"  name="newpassword" lay-verify="required" id="newpassword" placeholder="确认密码" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-form-item">
            <div class="layui-input-block">
              <input type="text" id="email" lay-verify="email|required" name="email"  placeholder="请输入邮箱" autocomplete="off" class="layui-input">
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
            <button id="res" class="layui-btn" >注册</button>
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
    }).use(['jquery','index','form','layer'],function(){
      var index = layui.index;
      var $ = layui.$;
      var layer=layui.layer
       index.seachBtn()
       index.login()
       index.arrowutil()

      $("#password").on("click",function (res) {
        $.get('${ctx}/user/finduser.action?username='+$("#username").val(),function (res) {
          if(res==1){
            layer.msg("用户名已被注册，请重新输入用户名")
          }
        })
      })

      $("#newpassword").on("click",function (res) {
        $.get('${ctx}/user/finduser.action?username='+$("#username").val(),function (res) {
          if(res==1){
            layer.msg("用户名已被注册，请重新输入用户名")
          }
        })
      })

      $("#email").on("click",function (res) {
        $.get('${ctx}/user/finduser.action?username='+$("#username").val(),function (res) {
          if(res==1){
            layer.msg("用户名已被注册，请重新输入用户名")
          }
        })
      })
      //监听注册按钮
      $("#res").on("click",function () {
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        $.get('${ctx}/user/finduser.action?username='+$("#username").val(),function (res) {
          if(res==1){
            layer.msg("用户名已被注册，请重新输入用户名")
          }else{
            if (reg.test($("#email").val())) {
              if ($("#checkbox").get(0).checked) {
                if($("#password").val()==$("#newpassword").val()&&$("#password").val()!=""&&$("#newpassword").val()!=""){
                  // $("#res").submit();
                  //alert($("#email").val())
                  if($("#password").val().length<20){
                    $.get("${ctx}/user/register.action?username="+$("#username").val()+"&password="+$("#password").val()+"&email="+$("#email").val(),function () {

                    })
                    //跳转到登录
                    window.location.href = "${ctx}/user/toLogin.action";
                  }else {
                    layer.msg("密码保持在20个字符以内")
                  }

                }else {
                  if($("#password").val()!=""&&$("#newpassword").val()!=""){
                    layer.msg('两次密码不相同')}
                  else{
                    layer.msg('密码不能为空')
                  }
                }
              }else {
                layer.msg('请同意用户协议和隐私')
              }
            }else {
              layer.msg('请输入正确的邮箱格式')
            }
          }
        })

        }
        )

      <%--//监听发送邮件--%>
      <%--$('#veriCodeBtn1').on("click",function () {--%>
      <%--  $.get("${ctx}/user/emailregister.action",function(data){--%>
      <%--    $('#veriCodeBtn1').attr('disabled',true);--%>
      <%--    var a=$('#email').val();--%>
      <%--     var len = 10;--%>

      <%--      if (a!="") {--%>
      <%--        $("#veriCodeBtn1").attr('value', len + 's');--%>
      <%--        var time = setInterval(function() {--%>
      <%--          len=len-1--%>
      <%--          $("#veriCodeBtn1").attr('value', len + 's')--%>
      <%--          if($("#veriCodeBtn1").val()=="0s"){--%>
      <%--            clearTimeout(time)--%>
      <%--            $("#veriCodeBtn1").attr('value', "重新发送")--%>
      <%--            $('#veriCodeBtn1').attr('disabled',false);--%>
      <%--          }--%>
      <%--        }, 1000);--%>
      <%--      } else {--%>
      <%--        layer.msg("邮箱不能为空")--%>
      <%--      }--%>

      <%--  });--%>
      <%--})--%>

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