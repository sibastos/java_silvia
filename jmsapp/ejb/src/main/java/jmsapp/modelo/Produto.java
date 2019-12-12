package jmsapp.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Double preco;
	private Integer idCli;
	
	public Produto() {
	}

	public Produto(String nome) {
		super();
		this.nome = nome;
	}

	public Produto(String nome, Double preco) {
		super();
		this.nome=nome;
		this.preco=preco;
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getIdCli() {
		return idCli;
	}

	public void setIdCli(Integer idCli) {
		this.idCli = idCli;
	}
	
	public String toString() {
		return ("id: "+this.id+" nome: "+this.nome+" preco: "+ this.preco);
		
	}
	
	
	
	
	
}
