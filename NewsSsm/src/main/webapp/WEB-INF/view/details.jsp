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
        <a id="new" href="${ctx}/user/index.action">最新</a>
        <a id="entertainment" href="${ctx}/news/entertainment.action">娱乐</a>
        <a id="life" href="${ctx}/news/life.action" >生活</a>
        <a id="money" href="${ctx}/news/money.action">财经</a>
        <a id="technology" href="${ctx}/news/technology.action">科技</a>
        <a id="military" href="${ctx}/news/military.action">军事</a>
      </p>
      <div class="search-bar">
        <form class="layui-form" action="${ctx}/news/search.action">
          <div class="layui-form-item">
            <div class="layui-input-block">
              <input type="text" name="title"  placeholder="搜索你要的内容" autocomplete="off" class="layui-input">
              <button class="layui-btn"  formnovalidate><i class="layui-icon layui-icon-search"></i></button>
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
          <li class="layui-nav-item"><a href="index.html">最新</a></li>
          <li class="layui-nav-item  layui-this"><a href="list.html">娱乐</a></li>
          <li class="layui-nav-item"><a href="list.html">生活</a></li>
          <li class="layui-nav-item"><a href="list.html">财经</a></li>
          <li class="layui-nav-item"><a href="list.html">科技</a></li>
          <li class="layui-nav-item"><a href="list.html">军事</a></li>
        </ul>
      </div>
    </div>
  </div>


  <div class="micronews-container micronews-details-container w1000">
    <div class="layui-fluid">
      <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md8">
          <div class="main">
            <!--这里是主要内容-->
            <div class="article">

              <div class="share-title">
                <span class="txt">分享:</span>
                <a href="#">
                  <i class="icon layui-icon layui-icon-login-wechat"></i>
                </a>
                <a href="#">
                  <i class="icon layui-icon layui-icon-login-weibo"></i>
                </a>
                <a href="#">
                  <i class="icon layui-icon layui-icon-login-qq"></i>
                </a>
                <button type="button" id="check" class="layui-btn layui-btn-sm">
                  <i class="layui-icon">&#xe600;</i><span id="like">收藏</span>
                </button>
              </div>
            </div>

            <div class="leave-message" id="message">
              <div class="tit-box">
                <span class="tit">网友跟帖</span>
                <span class="num"><b>500</b>条</span>
              </div>
              <div class="content-box">
                <div class="tear-box">
                  <a><img width="28px" height="28px" src="${ctx}/news/headphoto.action?status=1"></a>
                  <form class="layui-form">
                    <div class="layui-form-item layui-form-text">
                      <div class="layui-input-block">
                        <textarea id="onInput"  placeholder="请输入内容" class="layui-textarea"></textarea>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <div class="layui-input-block" style="text-align: right;">
                        <div class="message-text">
                          <div class="txt">

                          </div>
                        </div>
                        <button id="sub" type="button" class="layui-btn">发表</button>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="ulCommentList">

                </div>
                <div id="micronews-details-test" class="page" style="text-align: center;"></div>
              </div>
            </div>
          </div>
        </div>

        <script type="text/html" id="messageTpl">
          <div class="liCont">
            <a href="">
              <img src="{{d.avatar}}">
            </a>
            <div class="item-cont">
              <div class="cont">
                <p><span class="name">{{d.name}}</span><span class="time">刚刚</span></p>
                <p class="text">{{d.cont}}</p>
              </div>
            </div>
          </div>
        </script>

        <div class="layui-col-xs12 layui-col-sm12 layui-col-md4">
          <div class="popular-info popular-info-tog">
            <div class="layui-card">
              <div class="layui-card-header">
                <h3>资讯推荐</h3>
              </div>
              <div class="layui-card-body">
                <ul class="list-box">
                  <%-- 这里是资讯推荐 --%>
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
  <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <script>
    layui.config({
      base: '${ctx}/resource/res/static/js/'
    }).use('index',function(){
      var index = layui.index,$ = layui.$;
      index.EnterMessage()

      var collOff = true;
      $('.Collection').on('click',function(){
        if(collOff){
          $(this).addClass('active')
        }else{
          $(this).removeClass('active')
        }
        collOff = !collOff
      })
      index.seachBtn()
      index.onInput()
      index.arrowutil()
      //index.Page('micronews-details-test',20)
      //动态显示新闻
      $.get("${ctx}/news/details.action?status=0",function (res) {
        if(res.category=="娱乐"){
          $('#entertainment').attr("class","active")
        }else if(res.category=="生活"){
          $('#life').attr("class","active")
        }else if(res.category=="财经"){
          $('#money').attr("class","active")
        }else if(res.category=="科技"){
          $('#technology').attr("class","active")
        }else if(res.category=="军事"){
          $('#military').attr("class","active")
        }

        //这里是推荐资讯
        $.get("${ctx}/news/categoryHotNews.action?active="+$('.active').text(),function (res) {
          for(var i=0;i<res.length;i++){
            $('.list-box').append("<li class=\"list\">\n" +
                    "\n" +
                    "                      <a target=\"_blank\" href=\"${ctx}/news/detailsPage.action?title="+res[i]+"\">"+res[i]+"</a>\n" +
                    "\n" +
                    "                  </li>")
          }

        })

          $('.article').before("<div class=\"title\">\n" +
                  "              <h3>"+res.title+"</h3>\n" +
                  "              <div class=\"b-txt\">\n" +
                  "                <span class=\"label\">"+res.category+"</span>\n" +
                  "                <span class=\"icon\">\n" +
                  "                  <i class=\"layui-icon layui-icon-radio\"></i>\n" +
                  "                  <b>"+res.lookNum+"</b>人\n" +
                  "                </span>\n" +
                  "                <a href=\"#message\">\n" +
                  "                <span class=\"icon message\" >\n" +
                  "                  <i class=\"layui-icon layui-icon-dialogue\"></i>\n" +
                  "                  <b id='NUM'>"+res.replyNum+"</b>条\n" +
                  "                </span>\n" +
                  "                </a>\n" +
                  "                <span class=\"icon time\">\n" +
                  "                  <i class=\"layui-icon layui-icon-log\"></i>\n" +
                  "                  "+res.timeStr+"\n" +
                  "                </span>\n" +
                  "              </div>\n" +
                  "            </div>\n"+
                  "<div class=\"article\">"+
                  "<p class=\"source\">来源：<span>澎湃新闻网</span></p>\n" +
                  "<p class=\"original-tit mt30\">原标题：<span id='title'>"+res.title+"</span></p>\n" +
                  "</div>")
        for(var i=0;i<res.text.length;i++){
              if(i==1){
                var address=encodeURIComponent(res.photo)
                $('.share-title').before(
                        "              <div class=\"img-box\"><img width=\"600px\" height=\"400px\" onclick=\"javascript:window.open(this.src)\" src=\"${ctx}/news/headphoto.action?status=2&address="+address+"\"></div>\n" +
                        "              <p class=\"mt30\">"+res.text[i]+"</p>\n" )
              }else {
                $('.share-title').before("<p class=\"mt30\">"+res.text[i]+"</p>")
              }
        }

      })

      var page=1
      //这里还是评论区
      $.get("${ctx}/news/commens.action",function (res) {
        var limit=res.length
        num = limit
        var pagenum=num/4
        $('.num').text(num+"条")
        index.Page('micronews-details-test',pagenum*10)

        for(var i=(page-1)*4;i<4;i++){
          limit=limit-1;
          if(limit==-1){
            break;
          }
          var address=encodeURIComponent(res[i].photo)
          $(".ulCommentList").append("<div class=\"liCont\">\n" +
                  "                    <a><img width=\"28px\" height=\"28px\" src=\"${ctx}/news/headphoto.action?status=2&address="+address+"\"></a>\n" +
                  "                    <div class=\"item-cont\">\n" +
                  "                      <div class=\"cont\">\n" +
                  "                        <p><span class=\"name\">"+res[i].username+"</span><span class=\"time\">"+res[i].time+"</span></p>\n" +
                  "                        <p class=\"text\">"+res[i].text+"</p>\n" +
                  "                      </div>\n" +
                  "                    </div>\n" +
                  "                  </div>")
         }
       })

      //分页显示评论数
      $('.page').on('click',function(){
        page=$(".layui-laypage-curr").text()
        $.get("${ctx}/news/commens.action",function (res) {
          var limit=res.length
          num=res.length
          $('.ulCommentList').children().remove()
          limit=limit-(page-1)*4;
          for(var i=(page-1)*4;i<(page-1)*4+4;i++){
            limit=limit-1;
            if(limit<0){
              break;
            }
            var address=encodeURIComponent(res[i].photo)
            $(".ulCommentList").append("<div class=\"liCont\">\n" +
                    "                    <a><img width=\"28px\" height=\"28px\" src=\"${ctx}/news/headphoto.action?status=2&address="+address+"\"></a>\n" +
                    "                    <div class=\"item-cont\">\n" +
                    "                      <div class=\"cont\">\n" +
                    "                        <p><span class=\"name\">"+res[i].username+"</span><span class=\"time\">"+res[i].time+"</span></p>\n" +
                    "                        <p class=\"text\">"+res[i].text+"</p>\n" +
                    "                      </div>\n" +
                    "                    </div>\n" +
                    "                  </div>")
          }
        })
      })


      //监听发表按钮
      $('#sub').on("click",function(){
        if($('.login').text().indexOf("登录") >= 0 ) {
          layer.msg("登录才能发表")
        }else{
          if($('#onInput').val()!=""){
            var num=$('.num').text()
            num=parseInt(num)+1
            $('.num').text(num)
            //添加评论
            $(".ulCommentList").prepend("<div class=\"liCont\">\n" +
                    "            <a href=\"\">\n" +
                    "              <img src=\"${ctx}/news/headphoto.action?status=3\">\n" +
                    "            </a>\n" +
                    "            <div class=\"item-cont\">\n" +
                    "              <div class=\"cont\">\n" +
                    "                <p><span class=\"name\">${user.username}</span><span class=\"time\">刚刚</span></p>\n" +
                    "                <p class=\"text\">"+$('#onInput').val()+"</p>\n" +
                    "              </div>\n" +
                    "            </div>\n" +
                    "          </div>")
            $.get("${ctx}/news/inconmments.action?&text="+$('#onInput').val(),function (res){

            })
            var num=$('#NUM').text()
            num=parseInt(num)+1
            $('#NUM').text(num)
          }else {
            layer.msg("输入内容不能为空")
          }
        }
              }
      )
      //监听收藏按钮
      $('#check').on("click",function(){
        //如果收藏了
        if($('.login').text().indexOf("登录") >= 0 ) {
          layer.msg("登录才能收藏")
        }else {
            if($('#like').text()=="已收藏"){
              layer.msg("已取消收藏")
              $('#like').text("收藏")
              $.get("${ctx}/news/collection.action?flag=0",function () {
              })
            }else {
              layer.msg("已收藏")
              $('#like').text("已收藏")
              $.get("${ctx}/news/collection.action?flag=1",function () {
              })
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


      ///渲染新闻是不是早就被收藏了
      $.get("${ctx}/news/collectionop.action",function (res) {
        if(res>0){
          $("#like").text("已收藏")
          $("#check").eq($(this).index()).css('background', '#FF0000');
        }else {
          $("#like").text("收藏")
          $("#check").eq($(this).index()).css('background', '#FF0000');
        }
      })
      //到此为止了
    });
  </script>
</body>
</html>