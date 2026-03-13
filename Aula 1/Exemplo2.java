/*
  2. Padrões Estruturais (Conectando peças incompatíveis)
  Objetivo: Demonstrar como compor objetos e adaptar interfaces sem alterar o código original das classes.
*/

// Interface que o nosso sistema moderno entende
interface TomadaPadraoNovo {
    void ligarTresPinos();
}

// Classe legada (ou de terceiros) que não podemos alterar
class TomadaPadraoAntigo {
    public void ligarDoisPinos() {
        System.out.println("Ligado em dois pinos.");
    }
}

// PADRÃO ADAPTER: O intermediário que faz as duas conversarem
class AdaptadorDeTomada implements TomadaPadraoNovo {
    private TomadaPadraoAntigo tomadaAntiga;

    public AdaptadorDeTomada(TomadaPadraoAntigo antiga) {
        this.tomadaAntiga = antiga;
    }

    @Override
    public void ligarTresPinos() {
        System.out.println("Adaptando 3 pinos para 2...");
        tomadaAntiga.ligarDoisPinos(); // Delega a ação
    }
}
