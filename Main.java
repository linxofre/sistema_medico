package sistema_medico;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        // Criação de especialidades
        Especialidade clinicoGeral = new Especialidade(1, "Clínico Geral");
        Especialidade cardiologista = new Especialidade(2, "Cardiologista");
        Especialidade dermatologista = new Especialidade(3, "Dermatologista");
        Especialidade infectologista = new Especialidade(4, "Infectologista");
        Especialidade neurologista = new Especialidade(5, "Neurologista");
        Especialidade oftalmologista = new Especialidade(6, "Oftalmologista");
        Especialidade ortopedistaTraumatologista = new Especialidade(7, "Ortopedista e Traumatologista");
        Especialidade otorrinolaringologista = new Especialidade(8, "Otorrinolaringologista");
        Especialidade pediatra = new Especialidade(9, "Pediatra");
        Especialidade pneumologista = new Especialidade(10, "Pneumologista");
        Especialidade psiquiatra = new Especialidade(11, "Psiquiatra");
        Especialidade radioterapia = new Especialidade(12, "Especialista em Radioterapia");
        Especialidade urologista = new Especialidade(13, "Urologista");

        // Criação de médicos
        Medico josias = new Medico(new Date(), "Josias");
        Medico adalberto = new Medico(new Date(), "Adalberto");
        Medico maria = new Medico(new Date(), "Maria");
        Medico epaminondas = new Medico(new Date(), "Epaminondas");
        Medico marta = new Medico(new Date(), "Marta");
        Medico gezebel = new Medico(new Date(), "Gezebel");

        // Definindo a data de nascimento dos médicos
        josias.setDataNascimento(new Date(1975, 3, 15));
        adalberto.setDataNascimento(new Date(1980, 6, 22));
        maria.setDataNascimento(new Date(1985, 9, 10));
        epaminondas.setDataNascimento(new Date(1978, 11, 5));
        marta.setDataNascimento(new Date(1990, 2, 18));
        gezebel.setDataNascimento(new Date(1970, 8, 25));

        // Atribuição de especialidades a médicos
        josias.adicionarEspecialidade(clinicoGeral);
        josias.adicionarEspecialidade(cardiologista);
        josias.adicionarEspecialidade(infectologista);

        adalberto.adicionarEspecialidade(cardiologista);
        adalberto.adicionarEspecialidade(oftalmologista);

        maria.adicionarEspecialidade(ortopedistaTraumatologista);
        maria.adicionarEspecialidade(pediatra);
        maria.adicionarEspecialidade(psiquiatra);

        epaminondas.adicionarEspecialidade(psiquiatra);
        epaminondas.adicionarEspecialidade(radioterapia);
        epaminondas.adicionarEspecialidade(urologista);

        marta.adicionarEspecialidade(pneumologista);
        marta.adicionarEspecialidade(otorrinolaringologista);
        marta.adicionarEspecialidade(dermatologista);
        marta.adicionarEspecialidade(oftalmologista);

        gezebel.adicionarEspecialidade(clinicoGeral);
        gezebel.adicionarEspecialidade(neurologista);

        // Lista de médicos e especialidades
        List<Medico> medicos = Arrays.asList(josias, adalberto, maria, epaminondas, marta, gezebel);
        List<Especialidade> especialidades = Arrays.asList(
                clinicoGeral, cardiologista, dermatologista, infectologista, neurologista, oftalmologista,
                ortopedistaTraumatologista, otorrinolaringologista, pediatra, pneumologista, psiquiatra,
                radioterapia, urologista
        );

        // Exibição de médicos e especialidades
        System.out.println("Médicos e suas especialidades:");
        for (Medico medico : medicos) {
            System.out.println(medico);
            System.out.println();
        }

        System.out.println("Especialidades disponíveis:");
        for (Especialidade especialidade : especialidades) {
            System.out.println(especialidade);
            System.out.println();
        }

        // Perguntas ao usuário e criação de atendimento
        Date chegadaHospital = new Date();
        Date inicioAtendimento = new Date();
        Date fimAtendimento = new Date();

        Medico medicoResponsavel = null; // Inicialize como null
        Atendimento atendimento = null; // Inicialize como null

        System.out.println("Responda as perguntas de nível de prioridade:");

        String[] perguntas = {
            "Você está experimentando dor ou desconforto atualmente?",
            "Você já teve esse sintoma anteriormente?",
            "Você tem alguma alergia a medicamentos?",
            "Você notou uma piora rápida dos sintomas?",
            "Você tem alguma condição médica pré-existente que possa estar relacionada aos seus sintomas?"
        };

        for (int i = 0; i < 5; i++) {
            boolean respostaValida = false;
            char resposta;

            while (!respostaValida) {
                System.out.print(perguntas[i] + " (s/n): ");
                resposta = sc.next().charAt(0);

                if (resposta == 's' || resposta == 'S' || resposta == 'n' || resposta == 'N') {
                    respostaValida = true;

                    // Inicialize o objeto atendimento aqui se for a primeira iteração do loop
                    if (atendimento == null) {
                        atendimento = new Atendimento(chegadaHospital, inicioAtendimento, fimAtendimento, medicoResponsavel);
                    }

                    atendimento.getRespostas()[i] = (resposta == 's' || resposta == 'S');
                } else {
                    System.out.println("Resposta inválida. Responda com 's' ou 'n'.");
                }
            }
        }

        // Resto do código...
        System.out.println("Escolha uma especialidade pelo ID:");
        for (Especialidade especialidade : especialidades) {
            System.out.println(especialidade.getId() + " - " + especialidade.getNome());
        }

        int idEspecialidade = sc.nextInt();
        boolean especialidadeEncontrada = false;

        for (Medico medico : medicos) {
            for (Especialidade especialidade : medico.getEspecialidades()) {
                if (especialidade.getId() == idEspecialidade) {
                    medicoResponsavel = medico; // Defina o médico responsável aqui
                    atendimento.setEspecialidade(especialidade);
                    atendimento.setMedico(medico);
                    especialidadeEncontrada = true;
                    break;
                }
            }
            if (especialidadeEncontrada) {
                break;
            }
        }

        if (!especialidadeEncontrada) {
            System.out.println("Especialidade não encontrada.");
            sc.close();
            return;
        }

        System.out.println("Médicos disponíveis para a especialidade " + atendimento.getEspecialidade().getNome() + ":");
        for (Medico medico : medicos) {
            for (Especialidade especialidade : medico.getEspecialidades()) {
                if (especialidade.getId() == idEspecialidade) {
                    System.out.println("- " + medico.getNome());
                }
            }
        }

        sc.nextLine(); // Consumir a quebra de linha pendente
        System.out.print("Informe o nome do médico que irá atender o paciente: ");
        String nomeMedico = sc.nextLine();
        atendimento.setNomeMedico(nomeMedico);

        System.out.print("O paciente precisa de atestado médico? (s/n): ");
        char atestado = sc.next().charAt(0);
        atendimento.setEmitirAtestado(atestado == 's' || atestado == 'S');

        // Registra o horário de chegada ao hospital
        atendimento.setChegadaHospital(chegadaHospital);

        // Cálculo de prioridade
        atendimento.calcularPrioridade();

        // Registra o horário de início do atendimento
        atendimento.setInicioAtendimento(inicioAtendimento);

        // Simulação do atendimento (tempo gasto em milissegundos)
        try {
            Thread.sleep(2000); // Simulação de 2 segundos de atendimento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Registra o horário de fim do atendimento
        atendimento.setFimAtendimento(fimAtendimento);

        // Exibição das informações
        System.out.println("\nInformações do Atendimento:");
        System.out.println(atendimento);

        // Emite o atestado se necessário
        atendimento.emitirAtestado();

        sc.close();
    }
}
