<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
=======

>>>>>>> parent of ffa49c2 (Método cadastrarProduto funcionando)
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
<<<<<<< HEAD
=======
    
    public int cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
       
        int status;
        try {
            prep = conn.prepareStatement("INSERT INTO produtos(nome, valor) VALUES(?,?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());

            status = prep.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutosDTO produtos = new ProdutosDTO();

                produtos.setId(rs.getInt("id"));
                produtos.setNome(rs.getString("nome"));
                produtos.setValor(rs.getInt("valor"));
                produtos.setStatus(rs.getString("status"));

                listagem.add(produtos);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listagem;
    }
}
>>>>>>> parent of ffa49c2 (Método cadastrarProduto funcionando)

    public int cadastrarProduto(ProdutosDTO produto) {
        conn = new conectaDAO().connectDB();

        int status;
        try {
            prep = conn.prepareStatement("INSERT INTO produtos(nome, valor) VALUES(?,?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());

            status = prep.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutosDTO produtos = new ProdutosDTO();

                produtos.setId(rs.getInt("id"));
                produtos.setNome(rs.getString("nome"));
                produtos.setValor(rs.getInt("valor"));
                produtos.setStatus(rs.getString("status"));

                listagem.add(produtos);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
