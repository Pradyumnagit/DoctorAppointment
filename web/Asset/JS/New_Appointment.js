/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function openNav() {
    document.getElementById("mySidenav").style.width = "275px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}

$(document).ready(function () {

    $('#logout').click(function () {
        swal({
            title: "Are you sure to logout?",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
                .then((willDelete) => {
                    if (willDelete) {
                        swal({
                            title: "You are successfully logged out...",
                            text: "                                     ",
                            buttons: false,
                            icon: "success",
                        });
                        window.setTimeout(function () {
                            window.location.href = "index.jsp";
                        }, 1000);
                    } else {
                        swal({
                            title: "No Problem...",
                            icon: "success",
                        });
                    }
                });
    });
});


$(document).ready(function () {
    var td = new Date();

    $("#appointment_date").datepicker({
        minDate: 0,
    });


    $.ajax({
        url: "Doctor",
        method: "GET",
        success: function (data) {
            var d = JSON.parse(data);
//            console.log(d);
            for (var i = 0; i < d.userData.length; i++)
            {
                var str = "<option values=" + d.userData[i].name + ">" + d.userData[i].name + "</option>";
                $("#primary").append(str);

            }

        },
        error: function () {
            alert("JS ERROR............");
        }
    });
    $('#primary').click(function () {
        $('#secondary').empty();
        if ($("#primary").change())
        {

            var pr = $("#primary").val();
//            console.log(pr);

            $.ajax({
                url: "Doctor",
                method: "GET",
                success: function (data) {
                    var d = JSON.parse(data);
//                    console.log(d);
                    for (var i = 0; i < d.userData.length; i++)
                    {
                        if (d.userData[i].name != pr) {
                            var str = "<option values=" + d.userData[i].name + ">" + d.userData[i].name + "</option>";
                            $("#secondary").append(str);
                        } else
                        {

                        }

                    }

                },
                error: function () {
                    alert("JS ERROR............");
                }
            });



        }
    });


    $("#submit").click(function () {
        $.ajax({
            url: "NewAppointment",
            method: "POST",
            data: {
                patient_name: $("#patient_name").val(),
                patient_age: $("#patient_age").val(),
                patient_gender: $("#patient_gender").val(),
                primary: $("#primary").val(),
                secondary: $("#secondary").val(),
                appointment_date: $("#appointment_date").val(),
            }, success: function (response) {
//                console.log(response);
                if (JSON.parse(response).status === true) {
                    swal({
                        title: "Patient",
                        text: "is appointed",
                        icon: "success",
                        buttons: false,
                    });
                    window.setTimeout(function () {
                        location.reload();
                    }, 1000);

//                    location.reload("Patient_Registration.jsp");
                } else {
                    swal({
                        title: "Ooppss....!!",
                        text: "Patient is not appointed",
                        icon: "error",
                    });
                }
//                window.location.href="Patient_Registration.jsp";
            }, error: function (error) {
                console.log(error);
            }

        });

        return false;
    });
});