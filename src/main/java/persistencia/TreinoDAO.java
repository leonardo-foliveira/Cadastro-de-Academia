/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import negocio.Pagamento;
import negocio.Treino;

/**
 *
 * @author rafah
 */
public class TreinoDAO implements ITreinoDAO{
    
    private Connection connection;

    public TreinoDAO() {
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public void adiciona(Treino treino) {
        String sql = "insert into treino " +
            "(idAluno, descricao, data_fim, data_inicio)" +
            " values (?, ?, ?, now())";

        try {
            // preparar o comando para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // setando os atributos do objeto na cadeia sql
            stmt.setInt(1, treino.getIdAluno());
            stmt.setString(2, treino.getDescricao());
            //stmt.setDate(3, new Date(treino.getDataInicio().getTimeInMillis()));
            stmt.setDate(3, new Date(treino.getDataFim().getTimeInMillis()));

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void altera(Treino treino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Treino> listarTodos() {
        try {
            List<Treino> treinos = new ArrayList<Treino>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from treino as T inner join aluno as A on T.idAluno = A.idAluno");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Criando o objeto Paciente
                Treino treino = new Treino();
                
                // aluno.setNome(rs.getString("nome"));
                treino.setDescricao(rs.getString("descricao"));
                treino.setIdAluno(rs.getInt("idAluno"));
                
                // Montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_inicio"));
                treino.setDataInicio(data);
                Calendar data1 = Calendar.getInstance();
                data1.setTime(rs.getDate("data_fim"));
                treino.setDataFim(data1);

                
                // Adicionando o objeto à lista
                treinos.add(treino);
            }
            rs.close();
            stmt.close();
            return treinos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Treino getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
