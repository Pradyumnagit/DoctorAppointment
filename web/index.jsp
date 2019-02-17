<%-- 
    Document   : index
    Created on : Feb 6, 2019, 3:45:56 PM
    Author     : 1528110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIN</title>
        <link href="Asset/CSS/css.css" rel="stylesheet" type="text/css"/>
        <script src="Asset/JS/jquery.js" type="text/javascript"></script>
        <script src="Asset/JS/bootstrap.js" type="text/javascript"></script>
        <link href="Asset/CSS/index.css" rel="stylesheet" type="text/css"/>
        <script src="Asset/JS/Index.js" type="text/javascript"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>

            $(document).ready(function () {
                history.pushState(null, null, location.href);
                window.onpopstate = function () {
                    history.go(1);
                }
                
            });

//            $(document).ready(function () {
//                $.ajax({
//                    url:"",
//                    context:document.body,
//                    success:function (s,x){
//                        $('html[manifest=saveappoffline.appcache]').attr('content','');
//                            $(this).html(s);
//                    }
//                });
//            });

//            $(document).ready(function (){
//               
//            });
        </script>
    </head>
    <body background="Asset/Image/background.jpg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="row">
                        <img src="Asset/Image/projecthublogo.png" alt=""/>
                    </div>
                    <div class="row">
                        <form class="form-horizontal" action="AppointmetServlet" method="GET">
                            <br>
                            <div class="form-group">
                                &nbsp;&nbsp; <label class="control-label col-sm-3" for="email">Email:</label>
                                <div class="col-sm-8">
                                    <input type="email" class="form-control" id="user_email" name="user_email" placeholder="Enter Email" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-group">
                                &nbsp;&nbsp; <label class="control-label col-sm-3" for="email">Password:</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="user_password" name="user_password" placeholder="Enter Password" required>
                                </div>
                            </div>
                            <br>
                            <div class="form-group"> 
                                <div class="col-sm-offset-2 col-sm-9">
                                    <button type="submit" class="btn btn-primary" id="submit">Login</button>
                                </div>
                            </div>
                            <br>

                            <br>
                        </form>
                    </div>


                </div>
                <div class="col-sm-6 emergency_div">

                </div>
            </div>

        </div>

    </body>
</html>

