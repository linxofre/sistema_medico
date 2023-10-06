package sistema_medico;

import java.util.ArrayList;
import java.util.List;

class ListaAtendimento {
    private List<Atendimento> listaAtendimentos;

    public ListaAtendimento() {
        this.listaAtendimentos = new ArrayList<>();
    }

    public void addAtendimento(Atendimento atendimento) {
        listaAtendimentos.add(atendimento);
    }

    public List<Atendimento> mostrarLista() {
        return listaAtendimentos;
    }
}
