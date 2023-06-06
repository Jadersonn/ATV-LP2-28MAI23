package dao;
import java.util.List;

import entidades.Funcionario;

public interface FuncionarioDAO {
    void cadastrarFuncionario(Funcionario funcionario);
    void excluirFuncionario(int id);
    Funcionario buscarFuncionario(int id);
    List<Funcionario> listarFuncionarios();
	void atualizarFuncionario(Funcionario funcionario, int id);
}
