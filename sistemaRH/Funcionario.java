package sistemaRH;

public class Funcionario {
	private int funcionarioId;
    private String nome;
    private String cargo;
    private int departamentoId;
    
    //Metodo para setar funcionario lendo as informacoes do prompt
    public Funcionario( String nome2, String cargo2, int departamentoId2) {
		this.nome = nome2;
		this.cargo = cargo2;
		this.departamentoId  = departamentoId2;
	}
    
    //Metodo para salvar funcionario vindo do BD
	public Funcionario(int id, String nome2, String cargo2, int departamentoId2) {
		this.funcionarioId = id;
		this.nome = nome2;
		this.cargo = cargo2;
		this.departamentoId  = departamentoId2;
	}
	
	//Metodo para zerar funcionario caso precise
	public Funcionario() {
		this.setFuncionarioId(0);
		this.nome = "";
		this.cargo = "";
		this.departamentoId  = 0;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getDepartamentoId() {
		return departamentoId;
	}
	public void setDepartamentoId(int departamentoId) {
		this.departamentoId = departamentoId;
	}

	public int getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(int funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

   
}
