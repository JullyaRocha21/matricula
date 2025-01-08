package controllers;

import models.Aluno;
import models.Status;
import play.libs.Crypto;
import play.mvc.Controller;

public class Login extends Controller {

    public static void form() {
        render();
    }

    public static void logar(Integer matricula, String senha) {

        if (matricula == null || senha == null || senha.isEmpty()) {
            flash.error("Preencha os campos corretamente!");
            form();
        }

        Aluno aluno = Aluno.find("matricula = ?1 and senha = ?2 and status = ?3", matricula, Crypto.passwordHash(senha),
                Status.ATIVO).first();

        if (aluno == null) {
            flash.error("Matricula ou senha inválido(s)");
            form();
        }

        session.put("alunoLogado", aluno.matricula);
        flash.success("Bem-vindo(a)" + aluno.nome);
        Alunos.listar(null);
    }

    public static void logout() {
        session.clear();
        flash.success("Deslogado(a) com sucesso!");
        form();
    }

}
