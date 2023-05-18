package interfaces;
import sistemaRH.Funcionario;
import java.util.List;

public interface FuncionarioDAO {
    void cadastrarFuncionario(Funcionario funcionario);
    void excluirFuncionario(int id);
    Funcionario buscarFuncionario(int id);
    List<Funcionario> listarFuncionarios();
	void atualizarFuncionario(Funcionario funcionario, int id);
}
