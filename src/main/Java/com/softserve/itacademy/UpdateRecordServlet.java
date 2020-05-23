package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/update")
public class UpdateRecordServlet extends HttpServlet {

    private AddressBookDao abd;

    @Override
    public void init() throws ServletException {
        abd = AddressBookDao.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");



        if(abd.read(firstName.trim(), lastName.trim())==null) {

            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            request.setAttribute("name", firstName.trim() + " " + lastName.trim());
            request.getRequestDispatcher("/WEB-INF/error-page.jsp").forward(request, response);

        } else {

            abd.update(firstName.trim(), lastName.trim(), address.trim());
            response.sendRedirect("/records/list");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/update-record.jsp").forward(request, response);



    }
}
