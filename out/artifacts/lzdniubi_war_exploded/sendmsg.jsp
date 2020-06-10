<link rel="stylesheet" href="./dist/modules/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="./dist/modules/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="./dist/modules/fontawesome/web-fonts-with-css/css/fontawesome-all.min.css">

<link rel="stylesheet" href="./dist/css/demo.css">
<link rel="stylesheet" href="./dist/css/style.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-12 col-sm-10 offset-sm-1 col-md-8 offset-md-2 col-lg-8 offset-lg-2 col-xl-8 offset-xl-2">
        <div class="card card-primary">
            <div class="card-header"><h4>发送短信</h4></div>

            <div class="card-body">
                <form method="post" action="sendmsg.jhtml">
                    <div id="r_content" class="contents">${message}</div>

                    <div class="form-group">
                        <label>收件人</label>
                        <input type="text" class="form-control" name="receiver">

                    </div>

                    <div class="form-group" style="height: fit-content">
                        <label>内容</label>
                        <textarea type="text" class="form-control" name="content">${neirong}</textarea>
                    </div>

                    <div>
                        <br>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">
                            发送
                        </button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>