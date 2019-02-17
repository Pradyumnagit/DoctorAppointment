<%-- 
    Document   : Appointment_Details
    Created on : Feb 6, 2019, 6:20:00 PM
    Author     : 1528110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointment Details</title>
        <link href="Asset/CSS/css.css" rel="stylesheet" type="text/css"/>
        <script src="Asset/JS/bootstrap.js" type="text/javascript"></script>
        <script src="Asset/JS/jquery.js" type="text/javascript"></script>
        <link href="Asset/CSS/Appointment_Details.css" rel="stylesheet" type="text/css"/>
        <script src="Asset/JS/Appointment_Details.js" type="text/javascript"></script>
        <script src="Asset/JS/sweet_alert.js" type="text/javascript"></script>
    </head>

    <body background="Asset/Image/background.jpg">
        <div class="container">
            <div id="mySidenav" class="sidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <a href="Patient_Registration.jsp">Patient registration</a>
                <a href="New_Appointment.jsp">Doctor's appointment</a>
                <a href="Appointment_Details.jsp" class="active">Appointment details</a>
                <a href="#">Contact</a>
                <a href="#" id="logout">Logout</a>
            </div>

            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">

                    </div>
                    <ul class="nav navbar-nav">
                        <li><a onclick="openNav()" class="active" style="font-size:30px;cursor:pointer">&nbsp;&nbsp; &#9776; Menu &nbsp;&nbsp;</a></li>


                    </ul>
                    <img src="Asset/Image/projecthublogo.png" alt=""/>
                    
                </div>
            </nav>

            <div class="row">
                <div class="col-sm-offset-10">
                    <input type="date" class="form-control" id="fetch_date" name="fetch_date" required>
                </div>
            </div><br>
            <div class="row" id="data_fetch">
                
            </div>
        </div>
    </body>
</html>

