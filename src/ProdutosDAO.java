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

    public int cadastrarProduto(ProdutosDTO produto) {
        conn = new conectaDAO().connectDB();

        int status;
        try {
            prep = conn.prepareStatement("INSERT INTO produtos(nome, valor, status) VALUES(?,?, ?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());

            status = prep.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        conn = new conectaDAO().connectDB(); // CORREÇÃO: inicializar conexão aqui

        String sql = "SELECT * FROM produtos";
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                listagem.add(produto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listagem;
    }
}
