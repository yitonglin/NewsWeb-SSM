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
        <a href="${ctx}/user/index.action">最新</a>
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
              <button class="layui-btn" formnovalidate><i class="layui-icon layui-icon-search"></i></button>
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


  <div class="micronews-persInfo-wrap">
    <div class="micronews-container micronews-details-container micronews-persInfo-content w1000">
      <div class="layui-fluid">
        <div class="layui-row">
          <div class="layui-col-xs12 layui-col-sm12 layui-col-md3">
            <div class="popular-info">
              <div class="layui-card">
                <div class="layui-card-header">
                  <a href="#"><img id="me" width="80px" height="80px" src="${ctx}/myself/headphoto.action"></a>
                  <p class="name">${user.username}</p>
                </div>
                <div class="layui-card-body">
                  <ul class="tab" id="tabHeader"  lay-filter="myInfo">
                    <li lay-id="pl">我的评论</li>
                    <li lay-id="sc">我的收藏</li>
                    <li id="card">我的二维码</li>
                    <li style="color: #1E9FFF" id="unlogin">登出</li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          <div class="layui-col-xs12 layui-col-sm12 layui-col-md9">
            <div class="main">
              <div class="leave-message" id="tabBody">
                <!-- 我的评论 -->
                <div class="content-box">
                  <div class="ulCommentList" id="comments">
                      <%--我的评论内容--%>
                  </div>
                  <div id="micronews-details-test" style="text-align: center;"></div>
                </div>
                <!-- 结束-我的评论 -->

                <!-- 我的收藏 -->
                <div class="content-box">
                  <div class="ulCommentList" id="collection">
                    <!--我的收藏-->
                  </div>
                  <div id="micronews-details-test1" style="text-align: center;"></div>
                </div>
                <!-- 结束-我的收藏 -->
              </div>
            </div>
          </div>



        </div>
      </div>
    </div>
  </div>

  <div id="zxing" style="padding: 30px;display: none">

    <img alt="" src="${ctx}/myself/encode.action" >

    <div class="layui-row layui-col-space10">
      <div  class="layui-col-md6">
        <button  class="layui-btn layui-btn-radius  layui-btn-normal layui-btn-fluid" id="input"/>导出我的二维码</button>
      </div>
      <div class="layui-col-md6 ">
        <form method="post">
          <input  id="do"  class="layui-btn layui-btn-radius  layui-btn-normal layui-btn-fluid" value="二维码解析"/>
        </form>
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

  <!-- 添加和修改的弹出层开始 -->
  <div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
    <form class="layui-form layui-row layui-col-space10" action="${ctx}/myself/reMyself.action" lay-filter="dataFrm" id="dataFrm">
      <div class="layui-col-md12 layui-col-xs12">
        <div class="layui-row layui-col-space10">
          <div class="layui-col-md9 layui-col-xs7">
            <div class="layui-form-item magt3">
              <label class="layui-form-label">用户名:</label>
              <div class="layui-input-block">
                <input type="text" name="username" id="username" class="layui-input" lay-verify="required" placeholder="请输入用户名">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">密码:</label>
              <div class="layui-input-block">
                <input type="password" id="password" name="password" class="layui-input" lay-verify="required" placeholder="请输入密码">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">邮箱:</label>
              <div class="layui-input-block">
                <input type="text" id="email" name="email" class="layui-input" lay-verify="required|email" placeholder="请输入邮箱">
              </div>
            </div>
          </div>
          <div class="layui-col-md3 layui-col-xs5">
            <div class="layui-upload-list thumbBox mag0 magt3" id="carimgDiv">
              <!-- 显示上传的图片 -->
              <img width="135px" height="135px" class="layui-upload-img thumbImg" id="showCarImg">
              <!-- 保存当前显示图片的地址 -->
              <input type="hidden" name="photo" id="carimg">
              <input type="hidden" name="id" id="ids">
              <input type="hidden"  id="flag" class="ok">
            </div>
          </div>
        </div>

        <div class="layui-form-item magb0" style="text-align: center;">
          <div class="layui-input-block">
            <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">修改</button>
            <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
          </div>
        </div>
      </div>
    </form>

  </div>
  <script type="text/javascript" src="${ctx}/resource/res/layui/layui.js"></script>
  <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <script>
    layui.config({
      base: '${ctx}/resource/res/static/js/'
    }).use(['index','element','layer','upload','form'],function(){
      var index = layui.index,$ = layui.$,element = layui.element;var form=layui.form;

      index.arrowutil()
      var collOff = true;
      $('.Collection').on('click',function(){
        if(collOff){
          $(this).addClass('active')
        }else{
          $(this).removeClass('active')
        }
        collOff = !collOff
      })

      $('#card').on('click',function () {
        //个人二维码
        layer.open({
          title:"我的二维码名片",
          type: 1,
          content: $('#zxing')
        });
      })


       //监听登出
      $("#unlogin").on('click',function(){
        layer.open({
          title: '登出'
          ,content: '是否退出登录？',
          yes: function(index, layero){
            $.get("${ctx}/myself/unLogin.action",function () {
                layer.close(index); //如果设定了yes回调，需进行手工关闭
                window.location.href = "${ctx}/user/index.action";
            })

          }
        });
      })



      index.seachBtn()
      element.tab({
        headerElem: '#tabHeader>li' //指定tab头元素项
        ,bodyElem: '#tabBody>.content-box' //指定tab主体元素项
      });
      var layid = location.hash.replace(/^#myInfo=/, '');
      element.tabChange('myInfo', layid);

      //监听Tab切换，以改变地址hash值
      element.on('tab(myInfo)', function(){
        location.hash = 'myInfo='+ this.getAttribute('lay-id');
      });

      var url = window.location.hash;
      var loc = url && url.substring(url.lastIndexOf('=')+1, url.length) || false;
      if(loc){
        $("[lay-id="+loc+"]").trigger("click")
      }else{
        $("[lay-id=pl]").trigger("click")
      }
      //监听个人中心
      $('#me').on("click",function () {
        //渲染个人中心数据
        $.get("${ctx}/myself/lookMyself.action",function (res) {
          $('#username').val(res.username)
          $('#password').val(res.password)
          $('#email').val(res.email)
          $('#ids').val(res.id)
          if(res.photo==null){
            $("#showCarImg").attr("src","${ctx}/resource/res/static/images/header.png")
            $("#carimg").val("null")
          }else{
            var address=encodeURIComponent(res.photo)
            $("#showCarImg").attr("src","${ctx}/myself/headphoto.action")
            $("#carimg").val(address)
          }
        })
        openAddCar();
      })
      function openAddCar(){
        mainIndex=layer.open({
          type:1,
          title:'个人信息',
          content:$("#saveOrUpdateDiv"),
          area:['700px','280px'],
          success:function(index){
            //清空表单数据
            //$("#dataFrm")[0].reset();
            url="${ctx}/myself/reMyself.action";
            form.on('submit(doSubmit)', function(data){
              if(data.field.password.length<20){
                if($('#flag').attr("class")=="no"){
                  var address=encodeURIComponent($('#carimg').val())
                  $.post('${ctx}/myself/reMyself.action?username='+data.field.username+"&password="+data.field.password+"&email="+data.field.email+"&photo="+address+"&id="+data.field.id,function () {
                    layer.closeAll()
                    layer.msg("修改成功，请刷新浏览器")
                  })
                }else{
                  $.post('${ctx}/myself/reMyself.action?username='+data.field.username+"&password="+data.field.password+"&email="+data.field.email+"&photo="+$('#carimg').val()+"&id="+data.field.id,function () {
                    layer.closeAll()
                    layer.msg("修改成功，请刷新浏览器")
                  })
                }

              }else {
                layer.msg("密码保持在20字符以内")
              }
            });
          }
        });
      }
      //监听提交


      //上传图片
      //上传缩略图
      var upload=layui.upload;
      upload.render({
        elem: '#carimgDiv',
        url: '${ctx}/myself/uploadFile.action',
        method : "post",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        acceptMime:'images/*',
        field:"mf",
        done: function(res, index, upload){
          $('#flag').attr('class','no')
          var address=encodeURIComponent(res.data.src)
          $('#showCarImg').attr('src',"${ctx}/myself/downloadShowFile.action?path="+address+"&status=2");
          $('#carimg').val("D:\\news\\headPhoto\\"+res.data.src);
          $('#carimgDiv').css("background","#fff");
        }
      });


      //上传二维码
      var upload=layui.upload;
      upload.render({
        elem: '#do',
        url: '${ctx}/myself/decode.action',
        method : "post",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        acceptMime:'images/*',
        field:"mf",
        done: function(res, index, upload){
          layer.open({
            title:"二维码解析结果",
            type: 1,
            content:res.cont,
            area: ['400px', '150px']
          });
        }
      });


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

      //我的评论开始
      var page=1
      //渲染我的评论
      $.get('${ctx}/myself/lookMyselfComments.action?page='+page,function (res) {
        $('#comments').children().remove()
        for(var i=0;i<res.length;i++){
          var address=encodeURIComponent(res[i].photo)
          $('#comments').append("<div class=\"liCont\">\n" +
                  "                      <div class=\"item\">\n" +
                  "                        <div class=\"item-info\">\n" +
                  "                          <h4><a href=\"${ctx}/news/detailsPage.action?title="+res[i].title+"\">"+res[i].title+"</a></h4>\n" +
                  "                          <div class=\"b-txt\">\n" +
                  "                            <span class=\"label\">"+res[i].category+"</span>\n" +
                  "                            <span class=\"icon message\">\n" +
                  "                              <i class=\"layui-icon layui-icon-dialogue\"></i>\n" +
                  "                              "+res[i].replynum+"\n" +
                  "                            </span>\n" +
                  "                            <span class=\"icon time\">\n" +
                  "                              <i class=\"layui-icon layui-icon-log\"></i>\n" +
                  "                             "+res[i].ntime+"\n" +
                  "                            </span>\n" +
                  "                          </div>\n" +
                  "                        </div>\n" +
                  "                      </div>\n" +
                  "                      <a href=\"#\"><img src=\"${ctx}/myself/downloadShowFile.action?status=1&path="+address+"\"></a>\n" +
                  "                      <div class=\"item-cont\">\n" +
                  "                        <div class=\"cont\">\n" +
                  "                          <p><span class=\"name\">"+res[i].username+"</span><span class=\"time\">"+res[i].commentstime+"</span></p>\n" +
                  "                          <p class=\"text\">"+res[i].content+"</p>\n" +
                  "                        </div>\n" +
                  "                      </div>\n" +
                  "                    </div>")
        }
      })
      //监听页码点击
      $("#micronews-details-test").on('click',function () {
        var page=$(this).children().children(".layui-laypage-curr").text()
        $('#comments').children().remove()
        $.get('${ctx}/myself/lookMyselfComments.action?page='+parseInt(page),function (res) {
          for(var i=0;i<res.length;i++){
            var address=encodeURIComponent(res[i].photo)
            $('#comments').append("<div class=\"liCont\">\n" +
                    "                      <div class=\"item\">\n" +
                    "                        <div class=\"item-info\">\n" +
                    "                          <h4><a href=\"${ctx}/news/detailsPage.action?title="+res[i].title+"\">"+res[i].title+"</a></h4>\n" +
                    "                          <div class=\"b-txt\">\n" +
                    "                            <span class=\"label\">"+res[i].category+"</span>\n" +
                    "                            <span class=\"icon message\">\n" +
                    "                              <i class=\"layui-icon layui-icon-dialogue\"></i>\n" +
                    "                              "+res[i].replynum+"\n" +
                    "                            </span>\n" +
                    "                            <span class=\"icon time\">\n" +
                    "                              <i class=\"layui-icon layui-icon-log\"></i>\n" +
                    "                             "+res[i].ntime+"\n" +
                    "                            </span>\n" +
                    "                          </div>\n" +
                    "                        </div>\n" +
                    "                      </div>\n" +
                    "                      <a href=\"#\"><img src=\"${ctx}/myself/downloadShowFile.action?status=1&path="+address+"\"></a>\n" +
                    "                      <div class=\"item-cont\">\n" +
                    "                        <div class=\"cont\">\n" +
                    "                          <p><span class=\"name\">"+res[i].username+"</span><span class=\"time\">"+res[i].commentstime+"</span></p>\n" +
                    "                          <p class=\"text\">"+res[i].content+"</p>\n" +
                    "                        </div>\n" +
                    "                      </div>\n" +
                    "                    </div>")
          }
        })
      })
      //监听页码
      $.get('${ctx}/myself/lookMyselfCommentsNum.action',function (res) {
        res=res/6
        index.Page('micronews-details-test',res*10)
      })
      //我的评论结束

      //我的收藏开始
      var page=1
      //渲染我的收藏
      $.get('${ctx}/myself/lookMyselfCollection.action?page='+page,function (res) {
        $('#collection').children().remove()
        for(var i=0;i<res.length;i++){
          $('#collection').append("<div class=\"liCont\">\n" +
                  "                      <div class=\"item\">\n" +
                  "                        <div class=\"item-info\">\n" +
                  "                          <h4><a href=\"${ctx}/news/detailsPage.action?title="+res[i].newsname+"\">"+res[i].newsname+"</a></h4>\n" +
                  "                          <div class=\"b-txt\">\n" +
                  "                            <span class=\"label\">"+res[i].cname+"</span>\n" +
                  "                            <span class=\"icon message\">\n" +
                  "                              <i class=\"layui-icon layui-icon-dialogue\"></i>\n" +
                  "                              "+res[i].replynum+"\n" +
                  "                            </span>\n" +
                  "                            <span class=\"icon time\">\n" +
                  "                              <i class=\"layui-icon layui-icon-log\"></i>\n" +
                  "                             "+res[i].time+"\n" +
                  "                            </span>\n" +
                  "                          </div>\n" +
                  "                        </div>\n" +
                  "                      </div>\n" +
                  "                    </div>")
        }
      })
      //监听收藏页码点击
      $("#micronews-details-test1").on('click',function () {
        var page=$(this).children().children(".layui-laypage-curr").text()
        $('#collection').children().remove()
        $.get('${ctx}/myself/lookMyselfCollection.action?page='+parseInt(page),function (res) {
          for(var i=0;i<res.length;i++){
            $('#collection').append("<div class=\"liCont\">\n" +
                    "                      <div class=\"item\">\n" +
                    "                        <div class=\"item-info\">\n" +
                    "                          <h4><a href=\"${ctx}/news/detailsPage.action?title="+res[i].newsname+"\">"+res[i].newsname+"</a></h4>\n" +
                    "                          <div class=\"b-txt\">\n" +
                    "                            <span class=\"label\">"+res[i].cname+"</span>\n" +
                    "                            <span class=\"icon message\">\n" +
                    "                              <i class=\"layui-icon layui-icon-dialogue\"></i>\n" +
                    "                              "+res[i].replynum+"\n" +
                    "                            </span>\n" +
                    "                            <span class=\"icon time\">\n" +
                    "                              <i class=\"layui-icon layui-icon-log\"></i>\n" +
                    "                             "+res[i].time+"\n" +
                    "                            </span>\n" +
                    "                          </div>\n" +
                    "                        </div>\n" +
                    "                      </div>\n" +
                    "                    </div>")
          }
        })
      })
      //监听页码
      $.get('${ctx}/myself/lookMyselfCollectionNum.action',function (res) {
        res=res/6;
        index.Page('micronews-details-test1',res*10)
      })
      //我的收藏结束

      //导出二维码
      $('#input').on('click',function () {
        window.location.href="${ctx}/myself/exportZxing.action";
      })
    });
  </script>
</body>
</html>