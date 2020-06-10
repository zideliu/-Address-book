<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="dao.TxlDaoImp"%>
<%@page import="java.util.List"%>
<%@ page import="dao.MessageDaoImp" %>
<%@page import="entity.User"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Message" %>

<link rel="stylesheet" href="./dist/modules/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="./dist/modules/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="./dist/modules/fontawesome/web-fonts-with-css/css/fontawesome-all.min.css">

<link rel="stylesheet" href="./dist/css/demo.css">
<link rel="stylesheet" href="./dist/css/style.css">


<h4 class="section-title">收件箱</h4>

<div class="row">

    <%
        User user = (User)request.getSession().getAttribute("user");
        MessageDaoImp message_dao = new MessageDaoImp();
        List<Message> list = message_dao.getMessageByReceiver(user.getUsername());
        for (int i = 0; i < list.size(); i++) {
    %>

    <div class="col-12 col-sm-6 col-lg-3">
        <div class="card card-primary">
            <div class="card-header">
                <h4>FROM: <%=list.get(i).getSender()%></h4>
            </div>
            <div class="card-body">
                <code style="color: black"><%=list.get(i).getContent()%></code>
            </div>
            <div class="card-footer" style="text-align:right">
                <a href="delmsg.jhtml?id=<%=list.get(i).getId()%>" class="btn btn-sm btn-danger">删除</a>
            </div>
        </div>
    </div>
    <%
        }
    %>

</div>
</div>