//http:www.ciceroednilson.com.br/java-criando-um-client-rest-usando-jersey/
package jmsapp.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import jmsapp.modelo.Cliente;

public class ClienteService {
	/**GERENCIA A INFRAESTRUTURA DE COMUNIÇÃO DO LADO 
	 * CLIENTE PARA EXECUTAR AS SOLICITAÇÕES REALIZADAS*/
	private Client client;
 
	/**ACESSA UM RECURSO IDENTIFICADO PELO URI(Uniform Resource Identifier/Identificador Uniforme de Recursos)*/
	private WebTarget webTarget;
 
	/**URL DO SERVIÇO REST QUE VAMOS ACESSAR */
	private final String URL_SERVICE = "http://localhost:8081/cliente/";
 
	/**CONSTRUTOR DA NOSSA CLASSE*/
	public ClienteService(){
 
		this.client = ClientBuilder.newClient();  
	}
	
	/**CONSULTA UMA PESSOA PELO CÓDIGO ATRAVÉS DA OPERAÇÃO getPessoa(MÉTODO HTTP: GET)*/
	public Cliente ConsultarPessoaPorCodigo(int codigo){
 
		this.webTarget = this.client.target(URL_SERVICE).path(String.valueOf(codigo));
		
		System.out.println("==========================Essa é a URL=======================");
		System.out.println(this.webTarget.getUri());
 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
 
		Response response = invocationBuilder.get();
		
		System.out.println("==========================Essa é a resposta=======================");
		System.out.println(response);
		System.out.println(response.getLinks());
		System.out.println(response.getStatus());
		System.out.println(response.toString());
 
		return response.readEntity(Cliente.class);
 
	}
}
