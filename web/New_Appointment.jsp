<%-- 
    Document   : New_Appointment
    Created on : Feb 6, 2019, 6:19:44 PM
    Author     : 1528110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Appointment</title>
        <link href="Asset/CSS/css.css" rel="stylesheet" type="text/css"/>
        <script src="Asset/JS/bootstrap.js" type="text/javascript"></script>
        <script src="Asset/JS/jquery.js" type="text/javascript"></script>
        <script src="Asset/JS/New_Appointment.js" type="text/javascript"></script>
        <link href="Asset/CSS/New_Appointment.css" rel="stylesheet" type="text/css"/>
        <script src="Asset/JS/sweet_alert.js" type="text/javascript"></script>
        <link href="Asset/CSS/css_ui.css" rel="stylesheet" type="text/css"/>
        <script src="Asset/JS/jquery_ui.js" type="text/javascript"></script>
    </head>
    <body background="Asset/Image/background.jpg">
        <div class="container">
            <div id="mySidenav" class="sidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <a href="Patient_Registration.jsp">Patient registration</a>
                <a href="New_Appointment.jsp" class="active">Doctor's appointment</a>
                <a href="Appointment_Details.jsp">Appointment details</a>
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
                <div class="col-sm-offset-3 col-sm-6">
                    <form class="form-horizontal">

                        <div id="heading">
                            <h2>Doctor's Appointment</h2>
                            <hr>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="patient_name" name="patient_name" placeholder="Enter Patient Name" required>
                            </div>
                        </div>



                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Age:</label>
                            <div class="col-sm-4">
                                <input type="number" class="form-control" id="patient_age" name="patient_age" placeholder="Enter Age" min="1" max="120" required>
                            </div>
                            <label class="control-label col-sm-2" for="email">Gender:</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="patient_gender" name="patient_gender" required>
                                    <option values="Male">Male</option>
                                    <option values="Female">Female</option>
                                    <option values="Others">Others</option>
                                </select>

                            </div>							
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="email">Primary consultant:</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="primary" name="primary" required>

                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="email">Secondary consultant:</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="secondary" name="secondary" required>

                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-4" for="time">Appointment Date:</label>
                            <div class="col-sm-8"> 
                                <input type="text" class="form-control" id="appointment_date" name="appointment_date" required>
                                <!--<span class="input-group-addon"><span class="glyphicon-calendar glyphicon"></span></span>-->
                            </div>
                        </div>

                        <div class="form-group"> 
                            <div class="col-sm-12">
                                <div class="col-sm-offset-5">
                                    <button type="submit" class="btn btn-primary " id="submit">Submit</button>  
                                    <button type="reset" class="btn btn-danger" >Reset</button>	
                                </div>					
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <!--    <script>
            var date = new Date();
            date.setDate(date.getDate());
    
            $('#appointment_date').datepicker({
                startDate: date
            });
        </script>-->
</html>
