<%@page import="java.util.List"%>
<%@page import="entity.User"%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" name="viewport">
<title>Tables › Table — Stisla</title>

<link rel="stylesheet" href="./dist/modules/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="./dist/modules/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="./dist/modules/fontawesome/web-fonts-with-css/css/fontawesome-all.min.css">

<link rel="stylesheet" href="./dist/css/demo.css">
<link rel="stylesheet" href="./dist/css/style.css">
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
                <h4>通讯录</h4>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <th>用户名</th>
                            <th>邮箱</th>
                            <th>电话号码</th>
                            <th>邮编</th>
                            <th>地址</th>
                            <th>操作</th>
                        </tr>
                        <%
                            List<User> list=(List<User>) request.getAttribute("users");
                            for(int i=0;i<list.size();i++)
                            {
                        %>
                        <tr>
                            <td><%= list.get(i).getUsername()%></td>
                            <td><%= list.get(i).getEmail()%></td>
                            <td><%= list.get(i).getPhone()%></td>
                            <td><%= list.get(i).getYoubian()%></td>
                            <td><%= list.get(i).getAddress()%></td>
                            <td>
                                <a id="del" href="/DeleteContactAction?contact=<%=list.get(i).getUsername()%>" class="btn btn-action btn-danger">删除</a>
                            </td>
                        </tr>
                        <%} %>
                        </tbody></table>
                </div>
            </div>
            <div class="card-footer text-right">
                <nav class="d-inline-block">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link" href="#">首页</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="maillistmanage.jhtml?nowPage=${(nowPage<=1)?nowPage:(nowPage-1)}">上一页</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="maillistmanage.jhtml?nowPage=${(nowPage>=totalPage)?totalPage:(nowPage+1)}">下一页</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="maillistmanage.jhtml?nowPage=${totalPage}">尾页</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <script>
                function tz(){
                    var input=document.getElementById("toPageNum");
                    location.href = "maillistmanage.jhtml?nowPage="+input.value;
                }
            </script>
        </div>
    </div>
</div>