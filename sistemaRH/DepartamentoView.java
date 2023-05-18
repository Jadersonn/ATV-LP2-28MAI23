package sistemaRH;
import interfaces.DepartamentoDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoView implements DepartamentoDAO {
private Connection connection;

public DepartamentoView(Connection connection) {
    this.connection = connection;
}

@Override
public void cadastrarDepartamento(Departamento departamento) {
    String sql = "INSERT INTO departamento (id, nome) VALUES (?, ?)";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, departamento.getId());
        statement.setString(2, departamento.getNome());

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public void atualizarDepartamento(String nome, int num) {
    String sql = "UPDATE departamento SET nome = ? WHERE id = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, nome);
        statement.setInt(2, num);

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public void excluirDepartamento(int id) {
    String sql = "DELETE FROM departamento WHERE id = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public Departamento buscarDepartamento(int id) {
    String sql = "SELECT * FROM departamento WHERE id = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int departamentoId = resultSet.getInt("id");
            String nome = resultSet.getString("nome");

            return new Departamento(departamentoId, nome);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}

@Override
public List<Departamento> listarDepartamentos() {
    List<Departamento> departamentos = new ArrayList<>();

    String sql = "SELECT * FROM departamento";

    try (Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");

            Departamento departamento = new Departamento(id, nome);
            departamentos.add(departamento);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return departamentos;
}
}