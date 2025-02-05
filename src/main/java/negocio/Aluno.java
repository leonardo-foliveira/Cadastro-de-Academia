/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.Calendar;
import javax.xml.crypto.Data;

/**
 *
 * @author rafah
 */
public class Aluno {
    private int idAluno;
    private String nome;
    private int idade;
    private String telefone;
    private String email;
    private Calendar dataMatricula;

    public Aluno(int idAluno, String nome, int idade, String telefone, String email, Calendar dataMatricula) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        this.dataMatricula = dataMatricula;
    }
    
    public Aluno(){}

    public int getIdAluno() {
        return idAluno;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Calendar getDataMatricula() {
        return dataMatricula;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataMatricula(Calendar dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    
    
}
