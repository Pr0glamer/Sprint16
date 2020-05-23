package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/delete")
public class DeleteRecordServlet extends HttpServlet {

    private AddressBookDao abd;

    @Override
    public void init() throws ServletException {
        abd = AddressBookDao.getInstance();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("first-name");
        String lastName  = request.getParameter("last-name");
        abd.delete(firstName.trim(), lastName.trim());
        response.sendRedirect("/records/list");

    }
}
