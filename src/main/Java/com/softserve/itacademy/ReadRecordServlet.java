package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/read")
public class ReadRecordServlet extends HttpServlet {

    private AddressBookDao abd;

    @Override
    public void init() throws ServletException {
        abd = AddressBookDao.getInstance();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = abd.read(request.getParameter("first-name").trim(), request.getParameter("last-name").trim());

        if(address == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            request.setAttribute("name", request.getParameter("first-name").trim() + " " + request.getParameter("last-name").trim());
            request.getRequestDispatcher("/WEB-INF/error-page.jsp").forward(request, response);
        } else {

            request.setAttribute("address", address);
            request.getRequestDispatcher("/WEB-INF/read-record.jsp").forward(request, response);
        }

    }
}
