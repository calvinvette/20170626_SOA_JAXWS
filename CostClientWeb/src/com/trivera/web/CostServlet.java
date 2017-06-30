package com.trivera.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trivera.costservice.generated.CostService;
import com.trivera.costservice.generated.CostService_Service;

/**
 * Servlet implementation class CostServlet
 */
@WebServlet("/CostServlet")
public class CostServlet extends HttpServlet {
	private static CostService svc = new CostService_Service().getCostServiceSOAP();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/CostForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtNumItems = request.getParameter("numItems");
		Float numItems = Float.parseFloat(txtNumItems);
		Float cost = svc.calculateCost(numItems);
		response.getOutputStream().print(cost);
		response.getOutputStream().flush();
	}

}
