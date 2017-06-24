package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tub.as.smm.dao.ZaehlerDao;
import de.tub.as.smm.models.Zaehler;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet("/smartmeter")
public class SmartMeterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Injected DAO EJB:
    @EJB
    ZaehlerDao zaehlerDao;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Display the list of guests:
        request.setAttribute("smartmeter", zaehlerDao.getAllZaehler());
        request.getRequestDispatcher("/smartmeter.jsp").forward(request, response);
    }
 
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Handle a new guest:
        String name = request.getParameter("name");
        float maxAmpere = Float.valueOf(request.getParameter("maxAmpere"));
        float maxVolt = Float.valueOf(request.getParameter("maxVolt"));

        if (name != null && maxAmpere != 0.0f && maxVolt != 0.0f)
        	System.out.println(name);
            zaehlerDao.persist(new Zaehler(name, maxAmpere, maxVolt));
 
        // Display the list of guests:
        doGet(request, response);
    }
}
