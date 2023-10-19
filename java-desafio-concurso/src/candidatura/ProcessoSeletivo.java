package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main (String [] args) {
       // String [] candidatos = {"Felipe","Marcia","Julia","Mirela","Daniela"};

       // for (String candidato: candidatos) {

     //   }
    }

    static void entrandoEmContato (String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso");
        } while (continuarTentando && tentativasRealizadas < 3);
        if (atendeu)
            System.out.println("Contato com " + candidato + " em " + tentativasRealizadas + " tentativa(s)");
        else
            System.out.println("Sem contato com " + candidato + "tentativas encerradas");
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"Felipe","Marcia","Julia","Mirela","Daniela"};
        System.out.println("Imprimindo a lista de candidatos: ");

        for (int indice=0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de número " + (indice+1) + " é " + candidatos[indice]);
        }
        /*  abreviação
         *  for (String candidato: candidatos) {
         *      System.out.printIn("O candidato selecionado foi " + candidato);
         *  }
         */
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "Jorge"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salario: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase==salarioPretendido)
            System.out.println("Ligar para o candidato com contraproposta");
        else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}
