package com.people.servlets;

import com.people.models.User;
import com.people.servies.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserSimpleServlet extends HttpServlet {

    private UserService service = new UserService();

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = service.list();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showUsers.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        service.create(new User().setName(name));
        resp.sendRedirect("/users");
    }

    @Override
    protected void	doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = service.read(id);
        user.setName(req.getParameter("name"));
        service.update(user);
        resp.sendRedirect("/users");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.delete(service.read(id));
        resp.sendRedirect("/users");
    }
}
