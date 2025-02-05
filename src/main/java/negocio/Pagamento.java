/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author rafah
 */
public class Pagamento {
    private int idPagamento;
    private int idAluno;
    private Calendar dataPagamento;
    private float valor;

    
    public Pagamento(int idPagamento, int idAluno, Calendar dataPagamento, float valor) {
        this.idPagamento = idPagamento;
        this.idAluno = idAluno;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
    }
    
    public Pagamento(){}

    
    public int getIdPagamento() {
        return idPagamento;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public float getValor() {
        return valor;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
