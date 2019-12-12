package br.edu.infnet.clientService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cliente {
	
	
    @ApiModelProperty(value = "Código do cliente")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @ApiModelProperty(value = "Nome do cliente")
    @Column(nullable = false)
	private String nome;
    
    @ApiModelProperty(value = "Email do cliente")
    @Column(nullable = false)
	private String email;
    
    @ApiModelProperty(value = "CPF do cliente")
    @Column(nullable = false)
	private Long cpf;
    
    @ApiModelProperty(value = "Endereco do cliente")
    private String endereco;
    
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "Nome: "+nome+"\n cpf: "+cpf+"\n email: "+email+"\n endereço: "+endereco;
	}
	
	
	
	

}
