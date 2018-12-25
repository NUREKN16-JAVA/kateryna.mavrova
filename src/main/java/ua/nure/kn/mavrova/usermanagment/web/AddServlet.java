package main.java.ua.nure.kn.mavrova.usermanagment.web;
import ua.nure.kn.mavrova.usermanagment.User;
import ua.nure.kn.mavrova.usermanagment.db_2.DaoFactory;
import ua.nure.kn.mavrova.usermanagment.db_2.DatabaseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends ua.nure.kn.mavrova.usermanagment.web.EditServlet {
    public AddServlet() {
    }

    @Override
    protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void processUser(User user) throws DatabaseException {
        DaoFactory.getInstance().getUserDao().create(user);
    }
}