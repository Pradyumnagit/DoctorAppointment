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
    $("#submit").click(function () {
        $.ajax({
            url: "AppointmetServlet",
            method: "POST",
            data: {
                patient_name: $("#patient_name").val(),
                patient_age: $("#patient_age").val(),
                patient_gender: $("#patient_gender").val(),
                patient_comorbidity: $("#patient_comorbidity").val(),
                patient_alergies: $("#patient_alergies").val(),
                patient_address: $("#patient_address").val(),
                patient_zip: $("#patient_zip").val(),
                patient_id: $("#patient_id").val()
            }, success: function (response) {
                console.log(response);
                if (JSON.parse(response).status === true) {
                    swal({
                        title: "Patient",
                        text: "is registered",
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
                        text: "Patient is not registered",
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



