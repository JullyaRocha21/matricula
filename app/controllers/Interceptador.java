package controllers;

import play.mvc.Before;
import play.mvc.Controller;



public class Interceptador extends Controller {

    @Before(unless = {"Alunos.form","Alunos.salvar"})
    static void interceptador() {
        if (session.get("alunoLogado") == null) {
            flash.error(("Login necessário"));
            Login.form();
        }
    }

}
