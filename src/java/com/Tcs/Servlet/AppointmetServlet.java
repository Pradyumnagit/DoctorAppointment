/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tcs.Servlet;

import com.Tcs.Beans.Patientregistration;
import com.Tcs.Dao.AcessDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 1528110
 */
public class AppointmetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int i = 0;
        String email = request.getParameter("user_email");
        String password = request.getParameter("user_password");
        if (AcessDao.Login(email, password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("email", email);
            response.sendRedirect("Patient_Registration.jsp");

        } else {
            i = new AcessDao().block();
//            String str = "Login Attempt" + i;
            PrintWriter out = response.getWriter();
//            out.println(i);
            if (i < 3) {
                out.println("<script>");
                out.println("alert('Username or password is incorrect');");
                out.println("location='index.jsp';");
                out.println("</script>");
            } else {
                out.println("<script>");
                out.println("alert('Your acoount is locked');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String patient_name = request.getParameter("patient_name");
        String patient_age = request.getParameter("patient_age");
        String patient_gender = request.getParameter("patient_gender");
        String patient_comorbidity = request.getParameter("patient_comorbidity");
        String patient_alergies = request.getParameter("patient_alergies");
        String patient_address = request.getParameter("patient_address");
        String patient_zip = request.getParameter("patient_zip");
        String patient_id = request.getParameter("patient_id");
        PrintWriter out = response.getWriter();

//        if (patient_name == null || patient_age == null || patient_gender == null || patient_comorbidity == null || patient_alergies == null || patient_address == null || patient_zip == null || patient_id == null) {
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Don't try be smart');");
//            out.println("location='AppointmetServlet.java';");
//            out.println("</script>");
//            out.println("Don't try be smart");
//        } else {
        Patientregistration beans = new Patientregistration();
        beans.setAddress(patient_address);
        beans.setAge(Integer.parseInt(patient_age));
        beans.setAllergies(patient_alergies);
        beans.setComorbidities(patient_comorbidity);
        beans.setGender(String.valueOf(patient_gender.charAt(0)));
        beans.setIdentifier(patient_id);
        beans.setPatientName(patient_name);
        beans.setZipcode(Integer.parseInt(patient_zip));
        try {
            //        JSONObject temp = null;
//        try {
//            temp = AcessDao.Registartion(beans);
//        } catch (JSONException ex) {
//            Logger.getLogger(AppointmetServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (temp.status) {
            out.print(AcessDao.Registartion(beans));
//            request.setAttribute("result", temp);
//            request.getRequestDispatcher("Patient_Registration.jsp").forward(request, response);
//            out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Patient Successfully registered');");
//            out.println("swal({\n"
//                    + "title: \"Patient details\",\n"
//                    + "text: \"Successfully Registered\",\n"
//                    + "icon: \"success\",\n"
//                    + "button: \"OK..\",\n"
//                    + "});");
//            out.println("location='Patient_Registration.jsp';");
//            out.println("</script>");
        } catch (JSONException ex) {
            Logger.getLogger(AppointmetServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // }
}

