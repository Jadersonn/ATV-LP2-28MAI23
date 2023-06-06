package dao;
import 	java.util.List;

import entidades.Departamento;

public interface DepartamentoDAO {
    void cadastrarDepartamento(Departamento departamento);
    void excluirDepartamento(int id);
    Departamento buscarDepartamento(int id);
    List<Departamento> listarDepartamentos();
	void atualizarDepartamento(String nome, int num);
}
