<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="card-header"><h4>新增联系人</h4></div>

            <div class="card-body">
                <form method="post" action="addcontact.jhtml">
                    <div id="r_content" class="contents">${message}</div>

                    <div class="row">
                        <div class="form-group col-6">
                            <label>用户名</label>
                            <input type="text" class="form-control" name="add_name" autofocus>
                        </div>
                        <div class="form-group col-6">
                            <label>电话</label>
                            <input type="text" class="form-control" name="add_phone">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email">邮箱</label>
                        <input id="email" type="email" class="form-control" name="add_email">
                        <div class="invalid-feedback">
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
                            <input type="text" class="form-control" name="add_youbian">
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