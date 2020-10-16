<%--
  Created by IntelliJ IDEA.
  User: yiton
  Date: 2020/6/25
  Time: 11:03
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
<body class="micronews">
  <div class="micronews-header-wrap">
    <div class="micronews-header w1000 layui-clear">
      <h1 class="logo">
        <a href="${ctx}/user/index.action">
          <img src="${ctx}/resource/res/static/images/LOGO.png" alt="logo">
          <span class="layui-hide">LOGO</span>
        </a>
      </h1>
      <p class="nav">
        <a href="${ctx}/user/index.action" class="active">最新</a>
        <a href="${ctx}/news/entertainment.action">娱乐</a>
        <a href="${ctx}/news/life.action">生活</a>
        <a href="${ctx}/news/money.action">财经</a>
        <a href="${ctx}/news/technology.action">科技</a>
        <a href="${ctx}/news/military.action">军事</a>
      </p>
      <div class="search-bar">
        <form class="layui-form" action="${ctx}/news/search.action">
          <div class="layui-form-item">
            <div class="layui-input-block">
              <input type="text" name="title"  placeholder="搜索你要的内容" autocomplete="off" class="layui-input">
              <button class="layui-btn " formnovalidate><i class="layui-icon layui-icon-search"></i></button>
            </div>
          </div>
        </form>
      </div>
      <div class="login">

      </div>
      <div class="menu-icon">
        <i class="layui-icon layui-icon-more-vertical"></i>
      </div>
      <div class="mobile-nav">
        <ul class="layui-nav" lay-filter="">
          <li class="layui-nav-item layui-this"><a href="index.html">最新</a></li>
          <li class="layui-nav-item"><a href="list.html">娱乐</a></li>
          <li class="layui-nav-item"><a href="list.html">生活</a></li>
          <li class="layui-nav-item"><a href="list.html">财经</a></li>
          <li class="layui-nav-item"><a href="list.html">科技</a></li>
          <li class="layui-nav-item"><a href="list.html">军事</a></li>
        </ul>
      </div>
    </div>
  </div>

  <div class="micronews-container micronews-search-container w1000">
    <div class="layui-fluid">
      <p class="num">为您找到相关结果为<span id="sum"> </span>个</p>
      <div class="item-list">
<%--   这里是查询到的内容     --%>
      </div>
      <div class="page" id="micronews-search-test" style="text-align: center; padding:30px 0"></div>
    </div>
  </div>



  <div class="micronews-footer-wrap">
    <div class="micronews-footer w1000">
      <div class="ft-nav">
        <a href="#">关于我们</a>
        <a href="#">合作伙伴</a>
        <a href="#">广告服务</a>
        <a href="#">常见问题</a>
      </div>
      <div class="Copyright">
        <span>Copyright&nbsp;</span>&nbsp;&copy;<span>新闻网&nbsp;&nbsp;</span><span>赣ICP备12345678号</span>
      </div>
      <div class="f-icon">
        <a href="#" class="w-icon">
          <img src="${ctx}/resource/res/static/images/wechat_ic.png">
        </a>
        <a href="#" class="wb-icon">
          <img src="${ctx}/resource/res/static/images/qq_ic.png">
        </a>
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
    }).use(['index','jquery'],function(){
      var index = layui.index;var $=layui.jquery;
      var num

      var page=1;
      $('.page').on('click',function(){
        page=$(".layui-laypage-curr").text()
        $.get("${ctx}/news/searchnews.action",function (res) {
          var limit=res.length
          num=res.length
          $('.item-list').children().remove()
          limit=limit-(page-1)*10;
          for(var i=(page-1)*10;i<(page-1)*10+10;i++){
            limit=limit-1;
            if(limit<0){
              break;
            }
            $('.item-list').append("<div class=\"item\">\n" +
                  "          <h4><a href=\"${ctx}/news/detailsPage.action?title="+res.listNews[i].newsname+"\">"+res.listNews[i].newsname+"</a><span class=\"time\">"+res.listNews[i].time+"</span></h4>\n" +
                  "          <p>"+res.listNews[i].text+"</p>\n" +
                  "        </div>");
        }
        })
      })

      // var page=$(".layui-laypage-curr").text()
      // alert(page)
      //动态显示查询的
      $.get("${ctx}/news/searchnews.action",function (res) {
        var limit=res.countNum
        num = limit
        var pagenum=num/10
      //设置总条数
      $('#sum').text(num)
      //总条数，信息
      //页码
      index.Page('micronews-search-test',pagenum*10)
        for(var i=(page-1)*10;i<10;i++){
          limit=limit-1;
          if(limit==-1){
            break;
          }
          $('.item-list').append("<div class=\"item\">\n" +
                  "          <h4><a href=\"${ctx}/news/detailsPage.action?title="+res.listNews[i].newsname+"\">"+res.listNews[i].newsname+"</a><span class=\"time\">"+res.listNews[i].time+"</span></h4>\n" +
                  "          <p>"+res.listNews[i].text+"</p>\n" +
                  "        </div>");
        }
      })


      index.omitted('.item p',150)
      index.seachBtn()
      index.arrowutil()
        //这里是显示头像还是登录注册
        $.get("${ctx}/news/photo.action",function (res) {
            if(res=="nouser") {
                $('.login').append("<a href=\"${ctx}/user/toLogin.action\">\n" +
                    "        登录\n" +
                    "      </a>\n" +
                    "      <a href=\"${ctx}/user/registerView.action\">\n" +
                    "        注册\n" +
                    "      </a>")
            }else if(res=="user"){
                $('.login').append("<a href=\"${ctx}/news/perslnfo.action\">\n" +
                    "         <img src=\"${ctx}/myself/headphoto.action?status=1\" style=\"width: 36px; height: 36px;\">\n" +
                    "      </a> ")
            }
        })

    });


  </script>
</body>
</html>