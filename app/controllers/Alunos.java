package controllers;

import java.util.Arrays;
import java.util.List;

import models.Aluno;
import models.Nivel;
import models.Status;
import models.Turma;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Interceptador.class)
public class Alunos extends Controller {

	public static void form() {
		Aluno a = (Aluno) Cache.get("aluno");
		Cache.clear();

		List<Turma> turmas = Turma.findAll();
		List<Nivel> niveis = Arrays.asList(Nivel.values());
		render(a, turmas, niveis);
	}

	public static void salvar(@Valid Aluno a) {

		if (validation.hasErrors()) {
			validation.keep();
			flash.error("Preencha todos os campos!");
			Cache.set("aluno", a);
			form();
		}

		Aluno aluno = Aluno.find("matricula = ?1 and status = ?2", a.matricula, Status.ATIVO).first();

		if (a.id == null && aluno != null) {
			Cache.set("aluno", a);
			flash.error("Essa matricula já existe!");
			form();
		}

		String mensagem = "Cadastrado com sucesso!";

		if (a.id != null) {
			mensagem = "Editado com sucesso!";
		}

		a.save();
		flash.success(mensagem);
		listar(null);
	}

	public static void listar(String termo) {
		List<Aluno> lista = null;
		if (termo == null) {
			lista = Aluno.find("status like ?1", Status.ATIVO).fetch();
		} else {
			lista = Aluno.find("lower(nome) like ?1 or email like ?1 and status like ?2",
					"%" + termo.toLowerCase() + "%", Status.ATIVO).fetch();
		}
		render(lista, termo);
	}

	public static void editar(Long id) {
		Aluno a = Aluno.findById(id);
		List<Turma> turmas = Turma.findAll();
		renderTemplate("Alunos/form.html", a, turmas);

	}

	public static void remover(Long id) {
		Aluno a = Aluno.findById(id);
		a.status = Status.INATIVO;
		a.save();
		listar(null);
	}
}