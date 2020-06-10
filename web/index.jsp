<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="entity.User"%>
<%
        User user = (User)request.getSession().getAttribute("user");
%>
<html>
<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" name="viewport">
  <title>首页</title>
  <link rel="stylesheet" href="./dist/modules/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="./dist/modules/ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="./dist/modules/fontawesome/web-fonts-with-css/css/fontawesome-all.min.css">
  <link rel="stylesheet" href="./dist/css/demo.css">
  <link rel="stylesheet" href="./dist/css/style.css">

</head>
  <body class="sidebar-show">
  <div id="app">
    <div class="main-wrapper">
      <div class="navbar-bg"></div>
      <nav class="navbar navbar-expand-lg main-navbar">
        <form class="form-inline mr-auto">
          <ul class="navbar-nav mr-3">
            <li><a href="#" data-toggle="sidebar" class="nav-link nav-link-lg"><i class="ion ion-navicon-round"></i></a></li>
          </ul>
        </form>
        <ul class="navbar-nav navbar-right">
          <li class="dropdown"><a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle nav-link-lg">
            <i class="ion ion-android-person d-lg-none"></i>
            <div class="d-sm-none d-lg-inline-block">你好，${user.username}</div></a>
            <div class="dropdown-menu dropdown-menu-right">
              <a href="logout.jhtml" class="dropdown-item has-icon">
                <i class="ion ion-log-out"></i>注销
              </a>
            </div>
          </li>
        </ul>
      </nav>

      <div class="main-sidebar" tabindex="1" style="overflow: hidden; outline: none;">
        <aside id="sidebar-wrapper">
          <div class="sidebar-brand">
            <p></p><p></p>
            <a href="index.jsp" >ZI DE LIU</a>
          </div>
          <div class="sidebar-user">

          </div>
          <ul class="sidebar-menu" id="cebianlan">
            <li>
              <a href="index.jsp"><i class="ion ion-speedometer"></i><span>首页</span></a>
            </li>

            <li class="menu-header">通讯录管理</li>
            <li onclick="showlist()">
              <a href="#"><i class="ion ion-ios-location-outline"></i><span>通讯录</span></a>
            </li>
            <li onclick="addcontact()">
              <a href="#"><i class="ion ion-ios-location-outline"></i><span>新增联系人</span></a>
            </li>

            <li class="menu-header">短信管理</li>
            <li onclick="showmsglist();">
              <a href="#" ><i class="ion ion-ios-location-outline" ></i><span>收件箱</span></a>
            </li>
            <li onclick="sendmsg()">
              <a href="#"><i class="ion ion-ios-location-outline"></i><span>发送短信</span></a>
            </li>

            <li class="menu-header">个人管理</li>
            <li onclick="personalmsg()">
              <a href="#"><i class="ion ion-ios-location-outline"></i><span>个人信息</span></a>
            </li>

            <li onclick="personalmsgchange()">
              <a href="#"><i class="ion ion-ios-location-outline"></i><span>信息修改</span></a>
            </li>

          </ul>
        </aside>
      </div>

      <div class="main-content" style="min-height: 870px;">
        <section class="section">
          <h1 class="section-header">
            <div id="Top">Welcome!</div>
          </h1>
          <div class="section-body">
            <iframe src="" id="showframe" name="showframe" height="100%"  width="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes">

            </iframe>
          </div>
        </section>
      </div>

      <script src="./dist/modules/jquery.min.js"></script>
      <script src="./dist/modules/popper.js"></script>

      <script src="./dist/modules/tooltip.js"></script>
      <script src="./dist/modules/bootstrap/js/bootstrap.min.js"></script>
      <script src="./dist/modules/nicescroll/jquery.nicescroll.min.js"></script>
      <script src="./dist/modules/scroll-up-bar/dist/scroll-up-bar.min.js"></script>
      <script src="./dist/js/sa-functions.js"></script>

      <script src="./dist/js/scripts.js"></script>
      <script src="./dist/js/custom.js"></script>
<%--      <script src="./dist/js/demo.js"></script>--%>
    </div>
  </div>
  </body>
<script type="text/javascript">
  function showlist(){
    document.getElementById('Top').innerHTML="通讯录管理";
    $('#showframe').attr("src", "maillistmanage.jhtml");
  }
  function addcontact(){
    document.getElementById('Top').innerHTML="通讯录管理";
    $('#showframe').attr("src", "addcontact.jsp");
  }
  function showmsglist(){
    document.getElementById('Top').innerHTML="短信管理";
    $('#showframe').attr("src", "messagelist.jsp");
  }
  function sendmsg(){
    document.getElementById('Top').innerHTML="短信管理";
    $('#showframe').attr("src", "sendmsg.jsp");
  }
  function personalmsg(){
    document.getElementById('Top').innerHTML="个人管理";
    $('#showframe').attr("src", "personalmsg.jsp");
  }
  function personalmsgchange(){
    document.getElementById('Top').innerHTML="个人管理";
    $('#showframe').attr("src", "personalchange.jsp");
  }


</script>
</html>
