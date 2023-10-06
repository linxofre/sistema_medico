package sistema_medico;

import java.util.Date;

class Operacao {
    private Date inicio;
    private Date fim;

    public Operacao(Date inicio, Date fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public Date tempoTotal() {
        long diferenca = fim.getTime() - inicio.getTime();
        return new Date(diferenca);
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
}
