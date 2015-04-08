package br.com.oobj.jms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet({ "/JmsController", "/jmsController", "/ServletJMS", "/servletJMS" })
public class ServletJMS extends ServletGeral {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EnviarEmailJMSProducer produtor;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensagem = request.getParameter("mensagem");
		
		for (int i = 0; i < 50; i++) {
			produtor.enviarEmail(mensagem, "atilla8huno@gmail.com", "Contato via Portal");
		}
		
		response.sendRedirect("index.jsp");
	}
}
