package com.softserve.itacademy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/list")
public class RecordsListServlet extends HttpServlet {
    private AddressBookDao abd;

    @Override
    public void init() throws ServletException {
        abd = AddressBookDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sort = request.getParameter("sort");
        SortOrder s = sort == null || sort.equals("asc") ? SortOrder.ASC : SortOrder.DESC;
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/record-list.jsp");
        request.setAttribute("recordsIterator", abd.readAll(s));
        rd.forward(request, response);
    }
}
