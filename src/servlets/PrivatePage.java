package servlets;

import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns="/private")
public class PrivatePage extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute( "user" );
        if(session.getAttribute("login") == null)
        {
            //TODO 404
        }

        request.setAttribute("user", user);
        this.getServletContext().getRequestDispatcher("/WEB-INF/private.jsp").forward(request, response);
    }

}
