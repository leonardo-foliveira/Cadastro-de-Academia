/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Aluno;

/**
 *
 * @author rafah
 */
public interface IAlunoDAO {
    public void adiciona(Aluno aluno);
    public void altera(Aluno aluno);
    public void remove(int id);
    public List<Aluno> listarTodos();
    public List<Aluno> listarInadimplentes();
    public Aluno getByID(int id);
    public String getByIDNome(int id);
    
}
