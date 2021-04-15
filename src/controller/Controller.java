package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		// testando a conexão - testing conection
		// dao.testeConexao();
	}

	// listar contato - listing contacts
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("agenda.jsp");
		// recebendo os dados da classe JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
/*
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getFone());
			System.out.println(lista.get(i).getEmail());
		}*/
	}

	// Novo Contato - New Contact
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("agenda.jsp");
		// ** teste capturar dados do formulário
		// System.out.println(request.getParameter("nome"));
		// System.out.println(request.getParameter("telefone"));
		// System.out.println(request.getParameter("email"));
		// setar as variáveis javabeans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));

		// chamando insertContato
		dao.insertContato(contato);
		// redirect to agenda.jsp
		response.sendRedirect("main");
	}

	// Editar contato - Edit Contact
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// System.out.println(id);//teste de recebimento do ID

		// evio do ID - Send ID
		contato.setId(id);
		// executar o metodo selecionarContato - execute method selecionarContato
		dao.selecionarContato(contato);
		// test
		/*
		 * System.out.println(contato.getId()); System.out.println(contato.getNome());
		 * System.out.println(contato.getFone());
		 * System.out.println(contato.getEmail());
		 */
		// setar os atributos no formulário - show information in form edit
		request.setAttribute("id", contato.getId());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		// enviar para editar.jsp - send to editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste no console - test on console

		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("telefone"));
		System.out.println(request.getParameter("email"));
		

		// fim do teste//

		contato.setId(request.getParameter("id"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		// executar o metodo alterarContato - execute method alterarContato
		dao.alterarContato(contato);
		// redirecionar para agenda.jsp - redirect to agenda.jsp
		response.sendRedirect("main");

	}

	// remover cadastro - remove registration
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// System.out.println(id);//teste de recebimento do ID

		// evio do ID - Send ID
		contato.setId(id);
		// executando a exclusão - execute
		dao.deletarContato(contato);
		// redirecionar para agenda.jsp - redirect to agenda.jsp
		response.sendRedirect("main");

	}

}
