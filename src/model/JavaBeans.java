package model;

public class JavaBeans {
	
	private String id;
	private String nome;
	private String fone;
	private String email;
	
	//métodos construtores - construct method
	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public JavaBeans(String id, String nome, String fone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	//Gets and Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
