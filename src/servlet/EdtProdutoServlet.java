package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProdutoBD;
import objeto.Produto;

/**
 * Servlet implementation class EdtProdutoServlet
 */
//@WebServlet("/EdtProdutoServlet")
public class EdtProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EdtProdutoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("pages/alteraproduto.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("cod");
		HttpSession session = request.getSession();				
		
		Produto p = new Produto();
		p.setCodigo(codigo);
		p.setDescricao("0");
		p.setQtd("0");
		p.setPreco("0");
		p = ProdutoBD.buscarProduto(p);
		
		session.setAttribute("produto", p);
		response.sendRedirect("pages/alteraproduto.jsp");		
		session.setAttribute("aviso", "Produto não encontrado!");
			
		//doGet(request, response);
	}

}
