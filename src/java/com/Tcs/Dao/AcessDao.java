/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tcs.Dao;

import com.Tcs.Beans.Appointmentdetails;
import com.Tcs.Beans.Doctordetails;
import com.Tcs.Beans.Patientregistration;
import static com.Tcs.Dao.AcessDao.fetchUserData;
import com.Tcs.Utils.NewHibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 1528110
 */
public class AcessDao {

    public static boolean Login(String email, String password) {

        if (email.equals("demo@tcs.com") && password.equals("Tcs#1234") && Login_check()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean Login_check() {
        if (hack < 3) {
            return true;
        } else {
            return false;
        }
    }

    public static String Check(Patientregistration beans) {
        String bac = beans.getAddress() + " " + beans.getAllergies() + " " + beans.getComorbidities() + " " + beans.getGender() + " " + beans.getIdentifier() + " " + beans.getPatientName() + " " + beans.getAge() + " " + beans.getZipcode() + " " + beans.getPatientID();
        return bac;
    }

    public static JSONObject Registartion(Patientregistration beans) throws JSONException {
        JSONObject object = new JSONObject();

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(beans);
            session.getTransaction().commit();
            object.put("status", true);
        } catch (Exception ex) {
            ex.printStackTrace();
            object.put("status", false);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return object;
    }

    public static JSONObject Appointment(Appointmentdetails beans) throws JSONException {
        JSONObject object = new JSONObject();

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(beans);
            session.getTransaction().commit();
            object.put("status", true);
        } catch (Exception ex) {
            ex.printStackTrace();
            object.put("status", false);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return object;
    }

    public static JSONObject fetchUserData() throws JSONException {
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "SELECT a FROM Appointmentdetails a";
            Query query = session.createQuery(hql);

            List<Appointmentdetails> listUserDetailses = query.list();
            for (Appointmentdetails ud : listUserDetailses) {
                JSONObject temp = new JSONObject();
                temp.put("name", ud.getPatientname());
                temp.put("age", ud.getAge());
                temp.put("gender", ud.getGender());
                temp.put("pconsultant", ud.getPConsultant());
                temp.put("sconsultant", ud.getSConsultant());
                temp.put("date", ud.getDatetime());
                array.put(temp);
            }
            object.put("userData", array);
            object.put("status", true);

        } catch (Exception ex) {
            ex.printStackTrace();
            object.put("status", false);

        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return object;

    }

    public static JSONObject fetchDoctorData() throws JSONException {
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "SELECT d FROM Doctordetails d";
            Query query = session.createQuery(hql);

            List<Doctordetails> listUserDetailses = query.list();
            for (Doctordetails ud : listUserDetailses) {
                JSONObject temp = new JSONObject();
                temp.put("name", ud.getDoctorname());
                temp.put("dept", ud.getDepartment());
                array.put(temp);
            }
            object.put("userData", array);
            object.put("status", true);

        } catch (Exception ex) {
            ex.printStackTrace();
            object.put("status", false);

        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return object;

    }

    public static void main(String[] args) {
        System.out.println(AcessDao.block());
    }

    public static boolean Primary_Secondary(String primary, String secondary) throws JSONException {
        boolean b1 = false;
        boolean b2 = false;
        boolean b = false;
        ArrayList<String> al = new ArrayList<String>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "SELECT d FROM Doctordetails d";
            Query query = session.createQuery(hql);

            List<Doctordetails> listUserDetailses = query.list();
            for (Doctordetails ud : listUserDetailses) {
                al.add(ud.getDoctorname());
            }
            for (int i = 0; i < al.size(); i++) {
                if (al.get(i).equals(primary)) {
                    b1 = true;
                    break;
                } else {

                }
            }
            for (int j = 0; j < al.size(); j++) {
                if (al.get(j).equals(secondary)) {
                    b2 = true;
                    break;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        if (b1 && b2) {
            b = true;
        }
//        System.out.println(al);
        return b;
    }

    static int hack = 0;

    public static int block() {

//        System.out.print(hack);
        return ++hack;
    }
}
