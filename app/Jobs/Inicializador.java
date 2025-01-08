package Jobs;

import models.Nivel;
import models.Turma;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

// Já começa aplicação com turmas prontas (Sem precisar ficar criando toda hora)
@OnApplicationStart
public class Inicializador extends Job {

    @Override
    public void doJob() throws Exception {
        if (Turma.count() == 0) {

            Turma turma1 = new Turma();
            turma1.nome = "A-1";
            turma1.nivel = Nivel.INICIANTE;
            turma1.save();

            Turma turma2 = new Turma();
            turma2.nome = "A-2";
            turma2.nivel = Nivel.INTERMEDIÁRIO;
            turma2.save();

            Turma turma3 = new Turma();
            turma3.nome = "A-3";
            turma3.nivel = Nivel.AVANÇADO;
            turma3.save();

            Turma turma4 = new Turma();
            turma4.nome = "B-1";
            turma4.nivel = Nivel.INICIANTE;
            turma4.save();

            Turma turma5 = new Turma();
            turma5.nome = "B-2";
            turma5.nivel = Nivel.INTERMEDIÁRIO;
            turma5.save();

            Turma turma6 = new Turma();
            turma6.nome = "B-3";
            turma6.nivel = Nivel.AVANÇADO;
            turma6.save();

            Turma turma7 = new Turma();
            turma7.nome = "C-1";
            turma7.nivel = Nivel.INICIANTE;
            turma7.save();

            Turma turma8 = new Turma();
            turma8.nome = "C-2";
            turma8.nivel = Nivel.INTERMEDIÁRIO;
            turma8.save();

            Turma turma9 = new Turma();
            turma9.nome = "C-3";
            turma9.nivel = Nivel.AVANÇADO;
            turma9.save();

        }

    }
}
