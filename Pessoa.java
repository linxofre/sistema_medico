package sistema_medico;

import java.util.Date;

class Pessoa {
    private Date dataNascimento;
    private String nome;

    public Pessoa(Date dataNascimento, String nome) {
        this.dataNascimento = dataNascimento;
        this.nome = nome;
    }

    public int calcularIdade() {
        // Calcula a idade com base na data de nascimento
        Date dataAtual = new Date();
        int anoAtual = dataAtual.getYear();
        int anoNascimento = dataNascimento.getYear();
        return anoAtual - anoNascimento;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nIdade: " + calcularIdade();
    }
}
