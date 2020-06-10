<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" name="viewport">
    <title>注册</title>

    <link rel="stylesheet" href="./dist/modules/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./dist/modules/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="./dist/modules/fontawesome/web-fonts-with-css/css/fontawesome-all.min.css">

    <link rel="stylesheet" href="./dist/css/demo.css">
    <link rel="stylesheet" href="./dist/css/style.css">
</head>
<%--registe.jsp--%>
<body>
<div id="app">
    <section class="section">
        <div class="container mt-5">
            <div class="row">
                <div class="col-12 col-sm-10 offset-sm-1 col-md-8 offset-md-2 col-lg-8 offset-lg-2 col-xl-8 offset-xl-2">
                    <div class="login-brand">
                        ZI DE LIU
                    </div>

                    <div class="card card-primary">
                        <div class="card-header"><h4>注册</h4></div>

                        <div class="card-body">
                            <form method="post" action="/regist.jhtml">
                                <div id="r_content" class="contents">${message}</div>

                                <div class="row">
                                    <div class="form-group col-6">
                                        <label>用户名</label>
                                        <input type="text" class="form-control" name="r_name" autofocus>
                                    </div>
                                    <div class="form-group col-6">
                                        <label>电话</label>
                                        <input type="text" class="form-control" name="r_phone">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="email">邮箱</label>
                                    <input id="email" type="email" class="form-control" name="r_email">
                                    <div class="invalid-feedback">
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group col-6">
                                        <label for="password" class="d-block">密码</label>
                                        <input id="password" type="password" class="form-control" name="r_password">
                                    </div>
                                    <div class="form-group col-6">
                                        <label for="password2" class="d-block">确认密码</label>
                                        <input id="password2" type="password" class="form-control" name="r_password_check">
                                    </div>
                                </div>

                                <div class="form-divider">
                                    地址
                                </div>
                                <div class="row">
                                    <div class="form-group col-6">
                                        <label>省</label>
                                        <select class="form-control" name="s_province" id="s_province">

                                        </select>
                                    </div>
                                    <div class="form-group col-6">
                                        <label>市</label>
                                        <select class="form-control" name="s_city" id="s_city">

                                        </select>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group col-6">
                                        <label>区/县</label>
                                        <select class="form-control" name="s_county" id="s_county">

                                        </select>
                                    </div>
                                    <div class="form-group col-6">
                                        <label>邮编</label>
                                        <input type="text" class="form-control" name="r_youbian">
                                    </div>
                                </div>

                                <div>
                                    <br>
                                    <br>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">
                                        注册
                                    </button>
                                </div>

                                <script class="resources library" src="js/area.js" type="text/javascript"></script>

                                <script type="text/javascript">_init_area();</script>

                            </form>
                        </div>
                    </div>
                    <div class="mt-3 text-muted text-center">
                        已有账号? <a href="login.jsp">登录</a>
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

<script type="text/javascript">
    var Gid  = document.getElementById ;
    Gid('s_county').setAttribute('onchange','showArea()');
</script>
</body>
</html>