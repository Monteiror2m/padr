/*
  3. Padrões Comportamentais (Mudando algoritmos em tempo de execução)
  Objetivo: Mostrar como distribuir responsabilidades e trocar comportamentos dinamicamente, evitando classes "deus" cheias de regras de negócio.
*/

// Interface do comportamento
interface EstrategiaPagamento {
    void pagar(double valor);
}

// Implementações concretas
class PagamentoPix implements EstrategiaPagamento {
    public void pagar(double valor) { System.out.println("Pago via PIX: " + valor); }
}

class PagamentoCartao implements EstrategiaPagamento {
    public void pagar(double valor) { System.out.println("Pago via Cartão: " + valor); }
}

// PADRÃO STRATEGY: O contexto que usa a estratégia
class CarrinhoDeCompras {
    private EstrategiaPagamento estrategia;

    // O comportamento pode ser trocado com o programa rodando!
    public void setEstrategia(EstrategiaPagamento estrategia) {
        this.estrategia = estrategia;
    }

    public void fecharPedido(double valor) {
        estrategia.pagar(valor);
    }
}
