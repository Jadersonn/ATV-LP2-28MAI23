package view;
//Conexoes com o banco de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Listas para Funcionario e Departamento
import java.util.List;
import java.util.Scanner;

import dao.DepartamentoDAO;
import dao.DepartamentoView;
import dao.FuncionarioDAO;
import dao.FuncionarioView;
import entidades.Departamento;
import entidades.Funcionario;

public class Main {
	static String URL = "jdbc:mysql://localhost:3306/atvLP2";
    static String USERNAME = "root";
    static String PASSWORD = "";
    static Scanner leia = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException {
    	int opcao, opcaoFuncionario, opcaoDepartamento;
    	
    	do{
    		menu();
    		opcao = Integer.parseInt(leia.nextLine());
    			
    			switch(opcao) {
    				case 0:
    					break;
    				case 1: 
    					
    			    	do{
    			    		menuFuncionario();
    			    		
    			    		opcaoFuncionario = Integer.parseInt(leia.nextLine());
    			    			
    			    			switch(opcaoFuncionario) {
    			    				case 0:
    			    					break;
    			    				case 1: 
    			    					mostrarFuncionario();
    			    					break;
    			    				case 2: 
    			    					cadastrarFuncionario();
    			    					break;
    			    				case 3: 
    			    					editarFuncionario();
    			    					break;
    			    				case 4:
    			    					removerFuncionario();
    			    					break;
    			    				case 5: 
    			    					buscarFuncionario();
    			    					break;
    			    				default: 
    			    					System.out.println("Valor inserido nao e valido.");
    			    					break;
    			    			}
    			    	}while(opcaoFuncionario != 0);

    					break;
    				case 2: 
    					
    					do{
    						menuDepartamento();
    			    		
    						opcaoDepartamento = Integer.parseInt(leia.nextLine());
    			    			
    			    			switch(opcaoDepartamento) {
    			    				case 0:
    			    					break;
    			    				case 1: 
    			    					mostrarDepartamento();
    			    					break;
    			    				case 2: 
    			    					cadastrarDepartamento();
    			    					break;
    			    				case 3: 
    			    					editarDepartamento();
    			    					break;
    			    				case 4:
    			    					removerDepartamento();
    			    					break;
    			    				case 5:
    			    			        buscarDepartamento();
    			    					break;
    			    				default: 
    			    					System.out.println("Valor inserido nao e valido.");
    			    					break;
    			    			}
    			    	}while(opcaoDepartamento != 0);
    					break;
    				case 3: 
    					mostrarTodos();
    					break;
    				default: 
    					System.out.println("Valor inserido nao e valido.");
    					break;
    			}
    	}while(opcao != 0);
        
    }
    
    private static void mostrarTodos() throws SQLException {
    	Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    	if( connection != null) {
        	System.out.println("\n----------------------------------------------------");
        	System.out.println("\tConectado ao Banco de Dados.");
        	System.out.println("----------------------------------------------------");
        }
    	FuncionarioDAO funcionarioDAO = new FuncionarioView(connection);
    	DepartamentoDAO departamentoDAO = new DepartamentoView(connection);

    	// exibir funcionarios
    	List<Funcionario> funcionarios = funcionarioDAO.listarFuncionarios();
    	System.out.println("\tFuncionarios cadastrados:\n");
    	System.out.println("------------------------");
    	
    	//laco de repeticao (foreach) percorrendo e mostrando os funcionarios cadastrados
    	for (Funcionario funcionario : funcionarios) {
    	    System.out.println("ID: " + funcionario.getFuncionarioId());
    	    System.out.println("Nome: " + funcionario.getNome());
    	    System.out.println("Cargo: " + funcionario.getCargo());
    	    System.out.println("Departamento ID: " + funcionario.getDepartamentoId());
    	    System.out.println("------------------------");
    	}

    	// exibir departamentos
    	List<Departamento> departamentos = departamentoDAO.listarDepartamentos();
    	System.out.println("\n\n\tSetores cadastrados:");
    	System.out.println("------------------------");
    	
    	//laco de repeticao (foreach) percorrendo e mostrando os funcionarios cadastrados
    	for (Departamento departamento : departamentos) {
    	    System.out.println("ID: " + departamento.getId());
    	    System.out.println("Nome: " + departamento.getNome());
    	    System.out.println("------------------------");
    	}

	}

	private static void menuDepartamento() {
		System.out.println("\n1 - Mostrar Departamentos");
    	System.out.println("2 - Cadastrar Departamentos");
    	System.out.println("3 - Editar Departamento");
    	System.out.println("4 - Remover Departamento");
    	System.out.println("5 - Buscar Departameto");
    	System.out.println("0 - Sair");
    	System.out.print("Opcao: ");
		
	}
	
	private static void buscarDepartamento() {
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        DepartamentoDAO departamentoDAO = new DepartamentoView(connection);
			
	        System.out.println("Informe o id do departamento: ");
	        int id = Integer.parseInt(leia.nextLine());
	        Departamento departamento1 = departamentoDAO.buscarDepartamento(id);
	        if (departamento1 == null) {
	        	System.out.println("Departamento nao encontrado.");
	        }else {
	        	System.out.println(departamento1.getId() + " - " + departamento1.getNome());
		        }
	        connection.close();
	    	} catch (SQLException e) {
	    	e.printStackTrace();

		}
		    	
    }
	
	private static void removerDepartamento() {
		try {
	        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        DepartamentoDAO departamentoDAO = new DepartamentoView(connection);
	        mostrarDepartamento();
	        System.out.println("Informe o id do departamento a ser excluido: ");
	        int num = Integer.parseInt(leia.nextLine());
	        
	        departamentoDAO.excluirDepartamento(num);
	        
	        connection.close();
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	}
	
	private static void editarDepartamento() {
		try {
	        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        DepartamentoDAO departamentoDAO = new DepartamentoView(connection);
	        mostrarDepartamento();
	        System.out.println("Informe o id do departamento: ");
	        int num = Integer.parseInt(leia.nextLine());
	        
	        System.out.println("Informe o novo nome do departamento: ");
	        String nome = leia.nextLine();
	        departamentoDAO.atualizarDepartamento(nome, num);
	        
	        connection.close();
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	}
	
	private static void cadastrarDepartamento() {
		try {
	        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        DepartamentoDAO departamentoDAO = new DepartamentoView(connection);
			
	        System.out.println("Informe o nome do departamento: ");
	        String nome = leia.nextLine();
	        Departamento departamento1 = new Departamento(nome);
	        departamentoDAO.cadastrarDepartamento(departamento1);
	        
	        connection.close();
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	}
	
	private static void mostrarDepartamento() {
		try {
	        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        DepartamentoDAO departamentoDAO = new DepartamentoView(connection);
	        System.out.println("Lista de departamentos:");
	        List<Departamento> departamentos = departamentoDAO.listarDepartamentos();
	        for (Departamento d : departamentos) {
	            System.out.println(d.getId() + " - " + d.getNome());
	        }
	        connection.close();
	    } catch (SQLException e) {
        e.printStackTrace();
}
	}
	
	private static void menuFuncionario() {
		System.out.println("\n1 - Mostrar Funcionarios");
    	System.out.println("2 - Cadastrar Funcionarios");
    	System.out.println("3 - Editar Funcionario");
    	System.out.println("4 - Remover Funcionario");
    	System.out.println("5 - Buscar Funcionario");
    	System.out.println("0 - Sair");
    	System.out.print("Opcao: ");
		
	}
	
	private static void buscarFuncionario() {
		try {
	        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        FuncionarioDAO funcionarioDAO = new FuncionarioView(connection);
			System.out.print("Informe o id do Funcionario que deseja buscar: ");
	        int selecionou = Integer.parseInt(leia.nextLine());
	        Funcionario funcionario1 = funcionarioDAO.buscarFuncionario(selecionou);
	        if (funcionario1 == null) {
	        	System.out.println("Funcionario nao encontrado.");
	        }else {
	        	System.out.println(funcionario1.getNome() + " - " + funcionario1.getCargo() + " - " + funcionario1.getDepartamentoId());
		        }
			connection.close();
	    } catch (SQLException e) {
        e.printStackTrace();
}
	}
	
	private static void removerFuncionario() {
		try {
	        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        FuncionarioDAO funcionarioDAO = new FuncionarioView(connection);
	        mostrarFuncionario();
	        System.out.print("Informe o id do Funcionario que deseja apagar: ");
	        int selecionou = Integer.parseInt(leia.nextLine());
	        funcionarioDAO.excluirFuncionario(selecionou);
	        connection.close();
	    } catch (SQLException e) {
        e.printStackTrace();
}
	}
	
	private static void editarFuncionario() {
		try {
	        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        FuncionarioDAO funcionarioDAO = new FuncionarioView(connection);
	        mostrarFuncionario();
	        System.out.print("Informe o id do Funcionario que deseja editar: ");
	        int selecionou = Integer.parseInt(leia.nextLine());
	        System.out.println("Informe o novo nome do funcionario: ");
	        String nome = leia.nextLine();
	        System.out.println("Informe o novo nome do seu cargo: ");
	        String cargo = leia.nextLine();
	        mostrarDepartamento();
	        System.out.println("Informe o novo numero do seu departamento: ");
	        int departamento = Integer.parseInt(leia.nextLine());
	        

	        Funcionario funcionario1 = new Funcionario(nome, cargo, departamento);
	        funcionarioDAO.atualizarFuncionario(funcionario1, selecionou);
	        connection.close();
	    } catch (SQLException e) {
        e.printStackTrace();
}
	}
	
	private static void cadastrarFuncionario() {
		try {
	        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        FuncionarioDAO funcionarioDAO = new FuncionarioView(connection);
	        System.out.println("Informe o nome do funcionario: ");
	        String nome = leia.nextLine();
	        System.out.println("Informe o nome do seu cargo: ");
	        String cargo = leia.nextLine();
	        mostrarDepartamento();
	        System.out.println("Informe o numero do seu departamento: ");
	        int departamento = Integer.parseInt(leia.nextLine());
	        Funcionario funcionario1 = new Funcionario(nome, cargo, departamento);
	        funcionarioDAO.cadastrarFuncionario(funcionario1);
	        mostrarFuncionario();

	        connection.close();
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	}
	
	private static void mostrarFuncionario() {
		try {
	        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        FuncionarioDAO funcionarioDAO = new FuncionarioView(connection);
	       
	        System.out.println("Lista de funcionários:");
	        List<Funcionario> funcionarios = funcionarioDAO.listarFuncionarios();
	        for (Funcionario f : funcionarios) {
			System.out.println(f.getFuncionarioId() + " - " +f.getNome() + " - " + f.getCargo() + " - " + f.getDepartamentoId());
			}
	
	        connection.close();
	    } catch (SQLException e) {
        e.printStackTrace();
}
	}
	
	private static void menu(){
    	System.out.println("1 - Menu Funcionario");
    	System.out.println("2 - Menu Departamento");
    	System.out.println("3 - Mostrar Funcionario e Departamentos");
    	System.out.println("0 - Sair");
    	System.out.print("Opcao: ");
    }
}