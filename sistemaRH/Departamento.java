package sistemaRH;

public class Departamento {
    private int id;
    private String nome;
    
    public Departamento(){
		this.id  = 0;
		this.nome = "";
	}
    
	public Departamento(int departamentoId, String nome2) {
		this.id  = departamentoId;
		this.nome = nome2;
	}
	
	public Departamento(String nome){
		this.nome = nome;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}