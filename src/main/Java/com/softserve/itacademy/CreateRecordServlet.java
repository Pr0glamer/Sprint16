package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/records/create")
public class CreateRecordServlet extends HttpServlet {

    private AddressBookDao abd;

    @Override
    public void init() throws ServletException {
        abd = AddressBookDao.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");


        if(abd.read(firstName.trim(), lastName.trim()) != null) {

            request.setAttribute("error", "An error occurred! Please try again!");
            request.getRequestDispatcher("/WEB-INF/create-record.jsp").forward(request, response);


        } else {

            abd.create(firstName, lastName, address);
            response.sendRedirect("/records/list");
        }

       // AddressBookDao.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/create-record.jsp").forward(request, response);

    }
}
