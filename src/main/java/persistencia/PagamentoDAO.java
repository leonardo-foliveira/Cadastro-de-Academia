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
import negocio.Aluno;
import negocio.Pagamento;

/**
 *
 * @author rafah
 */
public class PagamentoDAO implements IPagamentoDAO{
    
    private Connection connection;

    public PagamentoDAO() {
        this.connection = new ConFactory().getConnection();
    }
    

    @Override
    public void adiciona(Pagamento pagamento) {
        String sql = "insert into pagamento " +
            "(idAluno, valor, data_pagamento)" +
            " values (?, ?, now())";

        try {
            // preparar o comando para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // setando os atributos do objeto na cadeia sql
            stmt.setInt(1, pagamento.getIdAluno());
            //stmt.setDate(2, new Date(pagamento.getDataPagamento().getTimeInMillis()));
            stmt.setFloat(2, pagamento.getValor());



            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void altera(Pagamento pagamento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pagamento> listarTodos() {
        try {
            List<Pagamento> pagamentos = new ArrayList<Pagamento>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from pagamento");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Criando o objeto Paciente
                Pagamento pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                
                pagamento.setIdAluno(rs.getInt("idAluno"));
                pagamento.setValor(rs.getFloat("valor"));

                // Montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_pagamento"));
                pagamento.setDataPagamento(data);

                // Adicionando o objeto à lista
                pagamentos.add(pagamento);
            }
            rs.close();
            stmt.close();
            return pagamentos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public Pagamento getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
