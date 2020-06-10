<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="entity.User"%>
<%
    User user = (User)request.getSession().getAttribute("user");
%>
<link rel="stylesheet" href="./dist/modules/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="./dist/modules/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="./dist/modules/fontawesome/web-fonts-with-css/css/fontawesome-all.min.css">

<link rel="stylesheet" href="./dist/css/demo.css">
<link rel="stylesheet" href="./dist/css/style.css">
<div class="row">
    <div class="col-12 col-sm-10 offset-sm-1 col-md-8 offset-md-2 col-lg-8 offset-lg-2 col-xl-8 offset-xl-2">
        <div class="login-brand">
            ZI DE LIU
        </div>

        <div class="card card-primary">
            <div class="card-header"><h4>信息修改</h4></div>

            <div class="card-body">
                <form method="post" action="changepersonal.jhtml">
                    <div id="r_content" class="contents">${message}</div>

                    <div class="row">
                        <div class="form-group col-6">
                            <label for="email">密码（留空则为不修改密码）</label>
                            <input id="password" type="password" class="form-control" name="change_password" >
                        </div>
                        <div class="form-group col-6">
                            <label>电话</label>
                            <input type="text" class="form-control" name="change_phone" value="<%=user.getPhone()%>">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email">邮箱</label>
                        <input id="email" type="email" class="form-control" name="change_email" value="<%=user.getEmail()%>">
                        <div class="invalid-feedback">
                        </div>
                    </div>

                    <div class="form-divider">
                        地址（当前地址：<%=user.getAddress()%>,留空则为不修改地址）
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
                            <input type="text" class="form-control" name="change_youbian" value="<%=user.getYoubian()%>">
                        </div>
                    </div>

                    <div>
                        <br>
                        <br>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">
                            保存
                        </button>
                    </div>

                    <script class="resources library" src="js/area.js" type="text/javascript"></script>

                    <script type="text/javascript">_init_area();</script>

                </form>
            </div>
        </div>
    </div>
</div>