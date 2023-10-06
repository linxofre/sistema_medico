package sistema_medico;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Medico {
    private Date dataNascimento;
    private String nome;
    private List<Especialidade> especialidades;

    public Medico(Date dataNascimento, String nome) {
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.especialidades = new ArrayList<>();
    }

    public void adicionarEspecialidade(Especialidade especialidade) {
        especialidades.add(especialidade);
    }

    public int getIdade() {
        LocalDate dataNascimentoLocal = this.dataNascimento.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNascimentoLocal, hoje);
        return periodo.getYears();
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Nome: ").append(nome).append("\n");
        builder.append("Data de Nascimento: ").append(formatarData(dataNascimento)).append("\n");
        builder.append("Especialidades:\n");
        for (Especialidade especialidade : especialidades) {
            builder.append("- ").append(especialidade.getNome()).append("\n");
        }
        return builder.toString();
    }

    private String formatarData(Date data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data);
    }
}
