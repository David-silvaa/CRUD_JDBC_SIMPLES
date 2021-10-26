package Sistema;

import java.util.Scanner;

import Beans.Pessoa;
import Dao.PessoaDAO;


public class Main {
	
    public static void main(String[] args) {

        Main m = new Main();
        m.Menu();
    }
	
	
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
	
	public void Menu() {
		
		System.out.println("1 - Adicionar Pessoa");
		System.out.println("2 - Listar todas as pessoas");
		System.out.println("3 - Excluir Pessoa");
		System.out.println("4 - Alterar Pessoa");
		
		int op = getScanner().nextInt();
		
		switch(op) {
			
			case 1:
				add_pessoa();
			case 2:
				listar_pessoas();
			case 3:
				excluir_pessoa();
			case 4 :
				alterar_pessoa();
            default:
                System.out.println("Digite uma opção valida!");
                Menu();
			
		}
		
	}	
		
	public void add_pessoa() {
		
		System.out.print("\nDigite o nome da Pessoa: ");
        String nome = getScanner().nextLine();
		//System.out.print("Digite o idade da Pessoa: "+ "\n");
        //int idade = getScanner().nextInt();
		System.out.print("Digite a CPF da Pessoa: ");
        String cpf = getScanner().nextLine();
		
        
        //Instanciei uma pessoa, normal...
        Pessoa p = new Pessoa(nome, cpf);

        //Instanciando a classe DAO da Pessoa, chamando o metodo add_pessoa e passando como parametro a pessoa
        //criada acima
        PessoaDAO pdao = new PessoaDAO();
        pdao.add_Pessoa(p);

        Menu();
	}
	
	public void listar_pessoas() {
		
		PessoaDAO people = new PessoaDAO();
		
		System.out.println("\t\n--- Todas as Pessoas ---\n");
		
        //Passando um for no arraylist que o metodo mostrar_pessoas retorna
        for (Pessoa p : people.mostrar_pessoas()) {
           
        	System.out.println("Nome: " + p.getNome());
            //System.out.println("Idade: " + p.getIdade());
            System.out.println("CPF: " + p.getCpf() + "\n");
        }
        
        Menu();

	}
	
    public void excluir_pessoa() {

        PessoaDAO pdao = new PessoaDAO();
        System.out.print("\nDigite o CPF da pessoa para remove-lá: ");

        String cpf = getScanner().next();
        pdao.delete_pessoa(cpf);
        Menu();
    }
		
    public void alterar_pessoa() {
    	
    	PessoaDAO pdao = new PessoaDAO();
    	
    	System.out.println("Digite o CPF da passoa para alterar: ");
    	String cpf = getScanner().next();
    	
    	Pessoa p = pdao.achar_pessoa(cpf);
    	
    	System.out.println("Alterando informações da pessoa: " + "\n");
    	
    	System.out.println("Nome " + p.getNome());
    	System.out.println("Cpf " + p.getCpf());
    	
    	System.out.println("\n Digitando as novas informações: \n");
    	
    	System.out.println("Nome: ");
    	String nome = getScanner().next();
    	
    	pdao.alterar_pessoa(p.getCpf(), nome);
    	
    	Menu();

    	
    }

}
