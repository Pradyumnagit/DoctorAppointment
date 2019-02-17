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
                            text:"                                     ",
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
    var dte = new Date();
    var str1 = dte.getFullYear() + "-0" + (dte.getMonth() + 1) + "-" + dte.getDate();
//    console.log(str1);
    $.ajax({
        url: "NewAppointment",
        method: "GET",
        success: (function (data) {
            var d = JSON.parse(data);
            var c = 0;
//            console.log(d.userData);
            var dt = JSON.stringify(d.userData[0].date);
            var arr = dt.split(" ");
            var arr1 = arr[0].replace('"', '');
//            console.log(arr1);
            var j = 1;
            for (var i = 0; i < d.userData.length; i++)
            {
                var dt = JSON.stringify(d.userData[i].date);
                var arr = dt.split(" ");
                var arr1 = arr[0].replace('"', '');

                if (arr1 === str1)
                {
                    c++;
                    var str = '<div class="well">' +
                            '<table class="table">' +
                            '<div class="row">' +
                            '<div class="col-sm-offset-5 col-sm-6">' +
                            '<h3>Appointment ' + j++ + '</h3>' +
                            '</div>' +
                            '</div>' +
                            '<tbody id="patient_details">' +
                            '<tr>' +
                            '<th>Name:</th>' +
                            '<td>' + d.userData[i].name + '</td>' +
                            '<th>Date:</th>' +
                            '<td>' + arr1 + '</td>' +
                            '</tr>' +
                            '<tr>' +
                            '<th>Age:</th>' +
                            '<td>' + d.userData[i].age + '</td>' +
                            '<th>Primary consultant</th>' +
                            '<td>' + d.userData[i].pconsultant + '</td>' +
                            '</tr>' +
                            '<tr>' +
                            '<th>Gender</th>' +
                            '<td>' + d.userData[i].gender + '</td>' +
                            '<th>Secondary consultant</th>' +
                            '<td>' + d.userData[i].sconsultant + '</td>' +
                            '</tr>' +
                            '</tbody>' +
                            '</table>' +
                            '</div>';

                    $("#data_fetch").append(str);
                }
            }
            if (c === 0)
            {
                swal({
                    title: "Oops....!!",
                    text: "No patient present today",
                    icon: "error",
                });
            }
        }),
        error: (function () {
            alert("JS ERROR......");
        })
    });
    $("#fetch_date").change(function () {
        $("#data_fetch").empty();
        var xyz = $("#fetch_date").val();
//        console.log(xyz);
        $.ajax({
            url: "NewAppointment",
            method: "GET",
            success: (function (data) {
                var c = 0;
                var d = JSON.parse(data);
//                console.log(d.userData);
                var i1 = 1;
                for (var i = 0; i < d.userData.length; i++)
                {

                    var dt = JSON.stringify(d.userData[i].date);
                    var arr = dt.split(" ");
                    var arr1 = arr[0].replace('"', '');
                    if (xyz === arr1)
                    {
                        c++;
                        var str = '<div class="well">' +
                                '<table class="table">' +
                                '<div class="row">' +
                                '<div class="col-sm-offset-5 col-sm-6">' +
                                '<h3>Appointment ' + (i1++) + '</h3>' +
                                '</div>' +
                                '</div>' +
                                '<tbody id="patient_details">' +
                                '<tr>' +
                                '<th>Name:</th>' +
                                '<td>' + d.userData[i].name + '</td>' +
                                '<th>Date:</th>' +
                                '<td>' + arr1 + '</td>' +
                                '</tr>' +
                                '<tr>' +
                                '<th>Age:</th>' +
                                '<td>' + d.userData[i].age + '</td>' +
                                '<th>Primary consultant</th>' +
                                '<td>' + d.userData[i].pconsultant + '</td>' +
                                '</tr>' +
                                '<tr>' +
                                '<th>Gender</th>' +
                                '<td>' + d.userData[i].gender + '</td>' +
                                '<th>Secondary consultant</th>' +
                                '<td>' + d.userData[i].sconsultant + '</td>' +
                                '</tr>' +
                                '</tbody>' +
                                '</table>' +
                                '</div>';

                        $("#data_fetch").append(str);
                    }
                }
                if (c === 0)
                {
                    swal({
                        title: "Oops....!!",
                        text: "No patient present on this date",
                        icon: "error",
                    });
                }
            }),
            error: (function () {
                alert("JS ERROR......");
            })
        });
    });
});
