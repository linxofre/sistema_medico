package sistema_medico;

import java.util.Date;

class Atestado extends Operacao {
    private String motivo;
    private String nomeMedico;
    private int tempoDias;

    public Atestado(Date inicio, Date fim, String motivo, String nomeMedico, int tempoDias) {
        super(inicio, fim);
        this.motivo = motivo;
        this.nomeMedico = nomeMedico;
        this.tempoDias = tempoDias;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public int getTempoDias() {
        return tempoDias;
    }

    public void setTempoDias(int tempoDias) {
        this.tempoDias = tempoDias;
    }

    @Override
    public String toString() {
        return "Atestado médico emitido por " + nomeMedico + " com motivo: " + motivo +
               ". Período: " + tempoTotal() + " (" + tempoDias + " dias)";
    }
}
