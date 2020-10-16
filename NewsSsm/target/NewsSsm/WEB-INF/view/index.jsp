<%--
  Created by IntelliJ IDEA.
  User: yiton
  Date: 2020/6/25
  Time: 11:01
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
            <input type="text" name="title" placeholder="搜索你要的内容" autocomplete="off" class="layui-input">
            <button class="layui-btn" id="search" formnovalidate><i class="layui-icon layui-icon-search"></i></button>
          </div>
        </div>
      </form>
    </div>
    <div class="login">
<%--  这里是显示头像或者登录注册    --%>
    </div>
    <div class="menu-icon">
      <i class="layui-icon layui-icon-more-vertical"></i>
    </div>
    <div class="mobile-nav">
      <ul class="layui-nav" lay-filter="">
        <li class="layui-nav-item layui-this"><a href="${ctx}/user/index.action">最新</a></li>
        <li class="layui-nav-item"><a href="list.html">娱乐</a></li>
        <li class="layui-nav-item"><a href="list.html">生活</a></li>
        <li class="layui-nav-item"><a href="list.html">财经</a></li>
        <li class="layui-nav-item"><a href="list.html">科技</a></li>
        <li class="layui-nav-item"><a href="list.html">军事</a></li>
      </ul>
    </div>
  </div>
</div>


<div class="layui-fulid micronews-banner w1000">
  <div class="layui-carousel imgbox" id="micronews-carouse">
    <div carousel-item>
      <div>
        <p id="lun" class="title">中国股市：为什么富人越炒越富，穷人越炒越穷？牢记犹太人“卖铜”思维。</p>
        <a class="lun" href="#"><img src="${ctx}/resource/res/static/images/026.png"></a>
      </div>
      <div>
        <p id="lan" class="title">特朗普真是"小天才"!在他的呼吁下，多家美企加大对中国的投资</p>
        <a class="lan" href="#"><img src="${ctx}/resource/res/static/images/024.png"></a>
      </div>
    </div>
  </div>
</div>


<div class="micronews-container w1000">
  <div class="layui-fluid">
    <div class="layui-row">
      <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">
        <div class="main">
          <div class="list-item" id="LAY_demo2">
            <%--这里是最新的新闻--%>
          </div>
        </div>
      </div>
      <div class="layui-col-xs12 layui-col-sm12 layui-col-md4">
        <div class="popular-info">
          <div class="layui-card">
            <div class="layui-card-header">
              <h3>热门资讯</h3>
            </div>
            <div class="layui-card-body">
              <ul class="list-box">
                <%--这里是热门资讯--%>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
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

<script>


  layui.config({
    base: '${ctx}/resource/res/static/js/'
  }).use(['index','jquery'],function(){
    var index = layui.index;
    var $=layui.$;
    index.banner()
    index.seachBtn()
    index.arrowutil()


    //动态显示新闻
    $.get("${ctx}/news/newsPage.action",function (res) {
      for(var i=0;i<res.length;i++){
        var imgage=encodeURIComponent(res[i].img)
        $('.list-item').append("<div class=\"item\">   \n" +
                "                <a href=\"${ctx}/news/detailsPage.action?title="+res[i].title+"\">\n" +
                "                <img class='title' width=\"160px\" height=\"100px\" src=\"${ctx}/news/categoryNewsPhoto.action?address="+imgage+"\">\n" +
                "                </a>\n" +
                "                <div class=\"item-info\">\n" +
                "                  <h4><a  class='title' href=\"${ctx}/news/detailsPage.action?title="+res[i].title+"\">"+res[i].title+"</a></h4>\n" +
                "                  <div class=\"b-txt\">\n" +
                "                    <span class=\"label\">"+res[i].label+"</span>\n" +
                "                    <span class=\"icon message\">\n" +
                "                      <i class=\"layui-icon layui-icon-dialogue\"></i>\n" +res[i].message+
                "                      \n" +
                "                    </span>\n" +
                "                    <span class=\"icon time\">\n" +
                "                      <i class=\"layui-icon layui-icon-log\"></i>\n" +res[i].time+
                "                      \n" +
                "                    </span>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>");
      }
    })


    //动态显示热门资讯
    $.get("${ctx}/news/hotNews.action",function (res) {
      for(var i=0;i<res.length;i++){
        if(i<=2) {
          $('.list-box').append("<li class=\"list\">\n" +
                  "\n" +
                  "                  <a class='title' href=\"${ctx}/news/detailsPage.action?title="+res[i]+"\">"+res[i]+"</a><i class=\"heat-icon\"></i>\n" +
                  "\n" +
                  "                </li>")
        }else{
          $('.list-box').append("<li class=\"list\">\n" +
                  "\n" +
                  "                  <a class='title' href=\"${ctx}/news/detailsPage.action?title="+res[i]+"\">"+res[i]+"</a></i>\n" +
                  "\n" +
                  "                </li>")
        }
      }
    })

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
                  "         <img src=\"${ctx}/myself/headphoto.action\" style=\"width: 36px; height: 36px;\">\n" +
                  "      </a> ")
        }
    })


    $('.lun').attr("href","${ctx}/news/detailsop.action?title=中国股市：为什么富人越炒越富，穷人越炒越穷？如果有10万资金，牢记犹太人“卖铜”思维，难怪这么赚钱")
    $('.lan').attr("href","${ctx}/news/detailsop.action?title=特朗普真是“小天才”！在他的呼吁下，多家美企加大对中国的投资")

  });
</script>
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</body>
</html>