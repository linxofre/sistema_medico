package sistema_medico;

import java.text.SimpleDateFormat;
import java.util.Date;

class Atendimento extends Operacao {
    private int prioridade;
    private int estado;
    private int cid;
    private boolean emitirAtestado;
    private boolean[] respostas;
    private Especialidade especialidade;
    private Medico medico;
    private Date chegadaHospital;
    private Date inicioAtendimento;
    private Date fimAtendimento;
    private String nomeMedico;
    
    // Construtor de Atendimento
    public Atendimento(Date chegadaHospital, Date inicioAtendimento, Date fimAtendimento, Medico medico) {
        super(inicioAtendimento, fimAtendimento); // Chama o construtor da classe pai Operacao
        this.emitirAtestado = false;
        this.respostas = new boolean[5];
        this.chegadaHospital = chegadaHospital;
        this.inicioAtendimento = inicioAtendimento;
        this.fimAtendimento = fimAtendimento;
        this.medico = medico;
    }

    public void calcularPrioridade() {
        // Calcula a prioridade com base nas respostas
        int respostasSim = 0;
        for (boolean resposta : respostas) {
            if (resposta) {
                respostasSim++;
            }
        }

        if (respostasSim == 5) {
            prioridade = 1; // Urgente
        } else if (respostasSim == 4) {
            prioridade = 2; // Grave
        } else if (respostasSim == 3 || respostasSim == 2) {
            prioridade = 3; // Normal
        } else if (respostasSim == 1) {
            prioridade = 4; // Atendimento regular
        } else {
            prioridade = 5; // Atendimento sem gravidade
        }
    }

    public void setRespostas(boolean[] respostas) {
        this.respostas = respostas;
    }

    public boolean[] getRespostas() {
        return respostas;
    }

    public void emitirAtestado() {
        // Emite um atestado se a resposta for sim
        if (emitirAtestado) {
            System.out.println("Atestado médico emitido para o paciente.");
        } else {
            System.out.println("Atestado médico não emitido.");
        }
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public boolean isEmitirAtestado() {
        return emitirAtestado;
    }

    public void setEmitirAtestado(boolean emitirAtestado) {
        this.emitirAtestado = emitirAtestado;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getChegadaHospital() {
        return chegadaHospital;
    }

    public void setChegadaHospital(Date chegadaHospital) {
        this.chegadaHospital = chegadaHospital;
    }

    public Date getInicioAtendimento() {
        return inicioAtendimento;
    }

    public void setInicioAtendimento(Date inicioAtendimento) {
        this.inicioAtendimento = inicioAtendimento;
    }

    public Date getFimAtendimento() {
        return fimAtendimento;
    }

    public void setFimAtendimento(Date fimAtendimento) {
        this.fimAtendimento = fimAtendimento;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat birthDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return "Nome do Médico: " + medico.getNome() +
                "\nData de Nascimento do Médico: " + birthDateFormat.format(medico.getDataNascimento()) +
                "\nEspecialidade: " + especialidade.getNome() +
                "\nNome do Paciente: Paciente Anônimo" +
                "\nPrioridade do Atendimento: " + prioridade +
                "\nHora de Chegada ao Hospital: " + dateFormat.format(chegadaHospital) +
                "\nHorário de Início do Atendimento: " + dateFormat.format(inicioAtendimento) +
                "\nHorário de Fim do Atendimento: " + dateFormat.format(fimAtendimento) +
                "\nTempo total do atendimento: " + tempoTotal() +
                "\nEmitir Atestado: " + emitirAtestado;
    }
}
