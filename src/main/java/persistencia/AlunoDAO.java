/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import negocio.Aluno;
import java.util.Calendar;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author rafah
 */
public class AlunoDAO implements IAlunoDAO{
    
    private Connection connection;

    public AlunoDAO() {
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public void adiciona(Aluno aluno) {
        String sql = "insert into aluno " +
            "(nome, idade, email, telefone, data_matricula)" +
            " values (?, ?, ?, ?, now())";

        try {
            // preparar o comando para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // setando os atributos do objeto na cadeia sql
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(3, aluno.getEmail());
            //stmt.setDate(5, new Date(aluno.getDataMatricula().getTimeInMillis()));



            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void altera(Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Aluno> listarTodos() {
        try {
            List<Aluno> alunos = new ArrayList<Aluno>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from aluno");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Criando o objeto Paciente
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idAluno"));
                
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));

                // Montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_matricula"));
                aluno.setDataMatricula(data);

                // Adicionando o objeto à lista
                alunos.add(aluno);
            }

            rs.close();
            stmt.close();
            return alunos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getByIDNome(int id) {
        try {
            List<Aluno> alunos = new ArrayList<Aluno>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from aluno");
            ResultSet rs = stmt.executeQuery();
            
            String nome = "Nao tem";
            while (rs.next()) {
                // Criando o objeto Paciente
                if (rs.getInt("idAluno") == id){
                    nome = rs.getString("nome");
                }
            }

            rs.close();
            stmt.close();
            
            return nome;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    
    @Override
    public List<Aluno> listarInadimplentes() {
        try {
            List<Aluno> alunos = new ArrayList<Aluno>();
            PreparedStatement stmt = this.connection.prepareStatement("select idAluno, nome, idade, telefone, email, data_matricula from aluno except select A.idAluno, A.nome, A.idade, A.telefone, A.email, A.data_matricula from aluno as A inner join pagamento as P on A.idAluno = P.idAluno;");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Criando o objeto Paciente
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idAluno"));
                
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setEmail(rs.getString("email"));

                // Montando a data através do Calendar
                
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_matricula"));
                aluno.setDataMatricula(data);

                // Adicionando o objeto à lista
                alunos.add(aluno);
            }

            rs.close();
            stmt.close();
            return alunos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
