<link rel="stylesheet" href="./dist/modules/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="./dist/modules/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="./dist/modules/fontawesome/web-fonts-with-css/css/fontawesome-all.min.css">

<link rel="stylesheet" href="./dist/css/demo.css">
<link rel="stylesheet" href="./dist/css/style.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="entity.User"%>
<%
    User user = (User)request.getSession().getAttribute("user");
%>
<div class="col-12 col-md-6 col-lg-6">
    <div class="card">
        <div class="card-header">
            <h4>个人信息</h4>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered">
                    <tbody><tr>
                        <th>用户名</th>
                        <th><%=user.getUsername()%></th>
                    </tr>
                    <tr>
                        <th>电话</th>
                        <th><%=user.getPhone()%></th>
                    </tr>
                    <tr>
                        <th>邮箱</th>
                        <th><%=user.getEmail()%></th>
                    </tr>
                    <tr>
                        <th>地址</th>
                        <th><%=user.getAddress()%></th>
                    </tr>
                    <tr>
                        <th>邮编</th>
                        <th><%=user.getYoubian()%></th>
                    </tr>
                    </tbody></table>
            </div>
        </div>
        <div class="card-footer text-right">
        </div>
    </div>
</div>