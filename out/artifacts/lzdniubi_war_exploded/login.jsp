<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String username = request.getParameter("name");
    String password = request.getParameter("password");
%>
<html lang="en"><head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" name="viewport">
    <title>登录</title>

<%--    <script type="text/javascript" src="js/login.js"></script>--%>
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

    <link rel="stylesheet" href="./dist/modules/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./dist/modules/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="./dist/modules/fontawesome/web-fonts-with-css/css/fontawesome-all.min.css">

    <link rel="stylesheet" href="./dist/css/demo.css">
    <link rel="stylesheet" href="./dist/css/style.css">
</head>
<body>
<div id="app">
    <section class="section">
        <div class="container mt-5">
            <div class="row">
                <div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">
                    <div class="login-brand">
                       ZI DE LIU
                    </div>

                    <div class="card card-primary">
                        <div class="card-header"><h4>登录</h4></div>

                        <div class="card-body">
                            <form id="log_reg_form" method="post" name="loginForm" action="/login.jhtml" class="needs-validation was-validated" novalidate="">

                                <div id="r_content" class="contents">${message}</div>

                                <div class="form-group">
                                    <label >账号</label>
                                    <input class="form-control" id="tid" name="name" type="text" tabindex="1">
                                </div>

                                <div class="form-group">
                                    <label >密码</label>
                                    <input type="password" name="password" id="pwd" class="form-control" tabindex="2" >
                                </div>

                                <div class="form-group">
                                    <label >验证码</label>
                                    <div>
                                        <input name="code" id="ident" class="form-control" style="width: auto;display: inline"/>
                                        <img src="code.jhtml" width="110px" height="43px"
                                             onclick="javascript:this.src='code.jhtml?id='+new Date().getMilliseconds()">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="login_botton btn btn-primary btn-block" tabindex="4" id="button" value="登  录">
                                        登录
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div>
                        <br>
                    </div>
                    <div class="mt-5 text-muted text-center">
                        还没有账号? <a href="regist.jsp">注册</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<script src="./dist/modules/jquery.min.js"></script>
<script src="./dist/modules/popper.js"></script>
<script src="./dist/modules/tooltip.js"></script>
<script src="./dist/modules/bootstrap/js/bootstrap.min.js"></script>
<script src="./dist/modules/nicescroll/jquery.nicescroll.min.js"></script>
<script src="./dist/modules/moment.min.js"></script>
<script src="./dist/modules/scroll-up-bar/dist/scroll-up-bar.min.js"></script>
<script src="./dist/js/sa-functions.js"></script>

<script src="./dist/js/scripts.js"></script>
<script src="./dist/js/custom.js"></script>


</body></html>
