package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entidades.Funcionario;

public class FuncionarioView implements FuncionarioDAO {
    private Connection connection;

    public FuncionarioView(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cargo, departamentoId) VALUES ( ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getCargo());
            statement.setInt(3, funcionario.getDepartamentoId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario, int id) {
        String sql = "UPDATE funcionario SET nome = ?, cargo = ?, departamentoId = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getCargo());
            statement.setInt(3, funcionario.getDepartamentoId());
            statement.setInt(4, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluirFuncionario(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario buscarFuncionario(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
            	int id1 = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                int departamentoId = resultSet.getInt("departamentoId");

                return new Funcionario(id1, nome, cargo, departamentoId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();

        String sql = "SELECT * FROM funcionario";

        try (Statement statement = connection.createStatement()) {
        	
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                int departamentoId = resultSet.getInt("departamentoId");

                Funcionario funcionario = new Funcionario(id, nome, cargo, departamentoId);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }



	
}
