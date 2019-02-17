/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tcs.Servlet;

import com.Tcs.Beans.Appointmentdetails;
import com.Tcs.Dao.AcessDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 1528178
 */
public class NewAppointment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AcessDao service = new AcessDao();
        PrintWriter out = response.getWriter();
        try {
            out.println(service.fetchUserData());
        } catch (JSONException ex) {
            Logger.getLogger(NewAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        PrintWriter out = response.getWriter();
//        out.println("HITTING");
        String patient_name = request.getParameter("patient_name");
        String patient_age = request.getParameter("patient_age");
        String patient_gender = request.getParameter("patient_gender");
        String primary = request.getParameter("primary");
        String secondary = request.getParameter("secondary");
        String appointment_date = request.getParameter("appointment_date");

        if (primary.equals(secondary)) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('dont try to be smart dude.......!!!!!!!!!!');");
            out.println("location='index.jsp';");
            out.println("</script>");
        } else {

            try {
                if (!AcessDao.Primary_Secondary(primary, secondary)) {

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Dont try to be smart dude.......!!!!!!!!!!');");
                    out.println("location='index.jsp';");
                    out.println("</script>");
                } else {
                    Appointmentdetails beans = new Appointmentdetails();

                    beans.setPatientname(patient_name);
                    beans.setAge(Integer.parseInt(patient_age));
                    beans.setGender(String.valueOf(patient_gender.charAt(0)));
                    beans.setPConsultant(primary);
                    beans.setSConsultant(secondary);
                    beans.setDatetime(appointment_date);
//                    if (AcessDao.Appointment(beans)) {
//                        out.println("<script type=\"text/javascript\">");
//                        out.println("alert('One patient successfuly appointed');");
//                        out.println("location='New_Appointment.jsp';");
//                        out.println("</script>");
//                    }
                    out.println(AcessDao.Appointment(beans));
                }
            } catch (JSONException ex) {
                Logger.getLogger(NewAppointment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
