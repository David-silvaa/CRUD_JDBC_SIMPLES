package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Pessoa;

public class PessoaDAO {
	
	private Connection con = null;
	
	//Sempre que instacia ele vai pegar a conexao com banco, da classe que criamos BancoConnection
	public PessoaDAO() {
		con = BancoConnection.getConnection();
	}
	
	public void add_Pessoa(Pessoa p) {
		
		String sql = "INSERT INTO pessoa (nome, cpf) VALUES (?, ?)";
		
		try {
			con = BancoConnection.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			//Preparo sendo feito, digo que no 1º '?' ele vai ser trocado pelo cpf da pessoa.
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCpf());
			
			//Query preparada com os devidos '?' substituidos pelos valores do obj carro, agora eu executo essa Query com o metodo execute().
			stmt.execute();
			System.out.println("\n" + "Pessoa adicionada com sucesso" + "\n");
			
			//Pronto aqui ele já inseriu no banco
		}catch(SQLException ex){
			
			System.out.println("Erro: " + ex);
			
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	
    public ArrayList<Pessoa> mostrar_pessoas() {
		
    	//ArrayList que irei retornar
    	ArrayList<Pessoa> retorno = new ArrayList<>();
    	
    	 //Query que irei lançar, padrão.
    	String sql = "SELECT * FROM pessoa";
  
    	try {
    		con = BancoConnection.getConnection();
    		
    		PreparedStatement stmt = con.prepareStatement(sql);
    		
    		ResultSet rs = stmt.executeQuery();
    		
    		while(rs.next()) { 	//O loop continua até não haver proxima pessoa
    			
    			Pessoa p = new Pessoa();
    			
    			p.setNome(rs.getString("nome"));
    			//p.setIdade(rs.getInt("idade"));
    			p.setCpf(rs.getString("cpf"));
    			
    			retorno.add(p);
    			
    		}
    		
    		rs.close();
    		
    		//Retorno um Array com todas pessoas cadastradas no BD
    		return retorno;
    		
    	}catch (SQLException x) {
    		System.err.println("Erro: " + x);
    		return null;
    	}finally {
    		BancoConnection.closeConnection(con);
    	}
    	
    }
    
	public void delete_pessoa(String cpf) {
		
		String sql = "DELETE FROM pessoa WHERE cpf = ?";
		
		
		try {
			
			con = BancoConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setNString(1, cpf);
			stmt.executeUpdate();
			
			
		}catch(SQLException ex) {
			System.out.println("Erro: " + ex);	
		}finally {
			BancoConnection.closeConnection(con);
		}
		
	}
	
	public Pessoa achar_pessoa(String cpf) {
		
		Pessoa p = new Pessoa();
		
		String sql = "SELECT * FROM pessoa WHERE cpf = ?";
		
		try {
			
			con = BancoConnection.getConnection();
			PreparedStatement stmt  = con.prepareStatement(sql);
			//Preparo sendo feito, digo que no 1º '?' ele vai ser trocado pelo cpf da pessoa que recebemos no parametro.
			
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				//Chamo o Setters padrão de pessoa, e no parametro coloco o rs.getTipo("nome_da_coluna_igual_do_banco");
				p.setCpf(rs.getString("cpf"));
				p.setNome(rs.getString("nome"));
				
			}
			return p;
			
			
			
		}catch(SQLException ex) {
			System.err.println("Erro: " + ex);
			return null;
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	
	public void alterar_pessoa(String cpf, String nome) {
		
		String sql = "UPDATE pessoa SET nome = ? WHERE cpf = ?";
		
		
		try {
			
			con = BancoConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, nome);
			stmt.setString(2, cpf);

			stmt.executeUpdate();
			System.out.println("\nPessoa Editada no Banco de Dados\n");
			
		}catch(SQLException ex) {
			System.err.println("Erro: " + ex);
		}finally {
			BancoConnection.closeConnection(con);
		}
	
	}
	
	
}
