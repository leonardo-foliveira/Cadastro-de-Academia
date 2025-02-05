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
public class Treino {
    private int idTreino;
    private int idAluno;
    private String descricao;
    private Calendar dataInicio;
    private Calendar dataFim;

    public Treino(int idTreino, int idAluno, String descricao, Calendar dataInicio, Calendar dataFim) {
        this.idTreino = idTreino;
        this.idAluno = idAluno;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    
    public Treino(){}

    public int getIdTreino() {
        return idTreino;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public String getDescricao() {
        return descricao;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }
    
    
}
