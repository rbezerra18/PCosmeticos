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
 * Servlet implementation class EdtProdutoServlet2
 */
//@WebServlet("/EdtProdutoServlet2")
public class EdtProdutoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EdtProdutoServlet2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("pages/alteraproduto2.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("cod");
		String descricao = request.getParameter("descricao");
		String qtd = request.getParameter("qtd");
		String preco = request.getParameter("preco");
		
		HttpSession session = request.getSession();		
		
		Produto produto = new Produto(codigo,descricao,qtd,preco);
		ProdutoBD.edtProduto(produto);		
		response.sendRedirect("pages/alteraproduto2.jsp");
		session.setAttribute("aviso", "Produto alterado!");
		//doGet(request, response);
	}

}
