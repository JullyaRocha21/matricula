package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.db.jpa.Model;

@Entity
public class Turma extends Model {

    public String nome;

    @Enumerated(EnumType.STRING)
    public Nivel nivel;

}
