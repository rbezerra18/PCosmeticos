package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objeto.GerarPDF;

/**
 * Servlet implementation class GerarPDFServlet
 */
//@WebServlet("/GerarPDFServlet")
public class GerarPDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerarPDFServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("pages/listaprodutos.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GerarPDF.geraPdf();
		
		HttpSession session = request.getSession();	
		
		response.sendRedirect("pages/listaprodutos.jsp");
		
		if(session != null){
			session.setAttribute("aviso3", "Arquivo gerado com sucesso!");
		}
		
		//doGet(request, response);
	}

}
