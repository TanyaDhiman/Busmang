
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class signup extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String userName=request.getParameter("username");
        String passW=request.getParameter("psw");
        //out.println("hello");
        loginDAO l = new loginDAO();
        try {
           String result = l.addData(userName, passW);
           if(result.equals("data inserted successfully"))
               response.sendRedirect("firstPage.html");
           else
               response.sendRedirect("login.html");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
