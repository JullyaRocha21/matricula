package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.data.validation.Email;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class Aluno extends Model {

	// A anotação de @required é para validar os dados, não permite valor null
	// (Age na action Alunos.salvar)

	@Required
	public String nome;

	@Required
	@Email(message = "O endereço de email é invalido")
	public String email;

	@Required
	@Min(0)
	public Integer matricula;

	@Required
	public String senha;

	@Required
	public Date dataMatricula;

	@Required
	public String endereco;

	@Required
	public String cidade;

	@Required
	public String estado;


	// Relacionamento com a classe Turma
	@Required
	@ManyToOne
	public Turma turma;

	// Enum para saber se a matricula ta ativa
	@Enumerated(EnumType.STRING)
	public Status status;

	// Quando um aluno for cadastrado, a data vai ser a data mesmo (sem ter q escolher).
	// E a matricula começa ativa.
	public Aluno() {
		this.status = Status.ATIVO;
		this.dataMatricula = new Date();
	}

	// Ação para criptografar a senha
	public void setSenha(String senha) {
		this.senha = Crypto.passwordHash(senha);
	}

}
