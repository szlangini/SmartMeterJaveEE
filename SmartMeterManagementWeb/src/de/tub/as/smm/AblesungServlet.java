package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tub.as.smm.dao.AblesungDao;
import de.tub.as.smm.dao.UserDao;
import de.tub.as.smm.dao.ZaehlerDao;
import de.tub.as.smm.models.Ablesung;
import de.tub.as.smm.models.Zaehler;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet(name = "/ablesung", urlPatterns = { "/ablesung" })
public class AblesungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Injected DAO EJB:
    @EJB
    AblesungDao ablesungDao;
    
    @EJB
    UserDao userDao;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	
        // Display the list of guests:
        request.setAttribute("ablesungen", ablesungDao.getAllAblesungen());
        request.getRequestDispatcher("/ablesung.jsp").forward(request, response);
        System.out.println("something");
        
    }
 
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	String id = request.getParameter("id");
    	System.out.println(id);

    	
    	
        // Handle a new guest:


        // CurrentSmartMeter über dao
    	float kWh = Float.valueOf(request.getParameter("kWh"));

            ablesungDao.persist(new Ablesung());
        
        // Display the list of guests:
        doGet(request, response);
    
}
}