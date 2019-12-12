package jmsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmsapp.jms.ConsumerJms;


@WebServlet(urlPatterns = "/send")
public class ProdutorJms extends HttpServlet {

	
	@Resource(lookup = "java:/myjms/mycon")
	ConnectionFactory connectionFactory;
	
	@Resource(lookup = "java:/myjms/myqueue")
	Destination destination;
	
	@Inject
	private ConsumerJms consumidor;
     
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cliente = req.getParameter("cliente");
		String total = req.getParameter("total");
		
		try {
			QueueConnection connection = (QueueConnection) connectionFactory.createConnection();
			
			QueueSession session = 
					connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			MessageProducer producer = session.createProducer(destination);
			
			TextMessage message = 
					     session.createTextMessage("O total do cliente "+cliente+" é: "+total+"." );
			
			producer.send(message);
			
			consumidor.onMessage(message);
			
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.print("Mensagem enviada com sucesso");

			
			producer.close();
			session.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	
	}


}
