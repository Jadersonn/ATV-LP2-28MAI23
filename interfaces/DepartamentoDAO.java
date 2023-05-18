package interfaces;
import 	sistemaRH.Departamento;
import 	java.util.List;

public interface DepartamentoDAO {
    void cadastrarDepartamento(Departamento departamento);
    void excluirDepartamento(int id);
    Departamento buscarDepartamento(int id);
    List<Departamento> listarDepartamentos();
	void atualizarDepartamento(String nome, int num);
}
