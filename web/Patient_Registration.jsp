<%-- 
    Document   : Home
    Created on : Feb 6, 2019, 3:54:52 PM
    Author     : 1528110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient_Registration</title>
        <link href="Asset/CSS/css.css" rel="stylesheet" type="text/css"/>
        <script src="Asset/JS/bootstrap.js" type="text/javascript"></script>
        <script src="Asset/JS/jquery.js" type="text/javascript"></script>
        <link href="Asset/CSS/Patient_Registration.css" rel="stylesheet" type="text/css"/>
        <script src="Asset/JS/Patient_Registration.js" type="text/javascript"></script>
        <script src="Asset/JS/sweet_alert.js" type="text/javascript"></script>

    </head> 
    <body background="Asset/Image/background.jpg">
        <div class="container">
            <div id="mySidenav" class="sidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <a href="Patient_Registration.jsp" class="active">Patient registration</a>
                <a href="New_Appointment.jsp">Doctor's appointment</a>
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
                            <h2>Patient Registration</h2>
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
                            <label class="control-label col-sm-2" for="email">Comorbidities:</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="patient_comorbidity" name="patient_comorbidity" placeholder="If any"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Alergies:</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="patient_alergies" name="patient_alergies" placeholder="If any"></textarea>

                            </div>
                        </div>



                        <div class="form-group">
                            <label class="control-label col-sm-2" for="address">Address:</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="patient_address" name="patient_address" placeholder="Enter Patient Address" required></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Zipcode:</label>
                            <div class="col-sm-4">
                                <input type="number" class="form-control" id="patient_zip" name="patient_zip" placeholder="Zipcode"  min="1" max="999999"  required>
                            </div>
                            <label class="control-label col-sm-1" for="email">ID:</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="patient_id" name="patient_id" placeholder="Enter ID Proof" required>

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
    </body>
</html>