package controllers;

import java.util.List;

import models.Aluno;
import models.Nivel;
import models.Turma;

public class Turmas extends play.mvc.Controller {

    public static void listar() {
        List<Turma> turmas = Turma.findAll();
        render(turmas);
    }

    public static void detalhar(Long id) {
        Turma turma = Turma.findById(id);
        List<Aluno> alunos = Aluno.find("turma", turma).fetch();
        render(alunos, turma);
    }

    public static void lista(String nivel) {
        List<Turma> turmas = Turma.find("nivel = ?1", Nivel.valueOf(nivel)).fetch();
        renderJSON(turmas);
    }

}
