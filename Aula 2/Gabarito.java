/*

*/

// 1. A Interface (O Contrato comum)
interface Relatorio {
    void gerar();
}

// 2. As Implementações Concretas
class RelatorioPDF implements Relatorio {
    @Override
    public void gerar() { System.out.println("Gerando relatório em formato PDF..."); }
}

class RelatorioExcel implements Relatorio {
    @Override
    public void gerar() { System.out.println("Gerando relatório em formato Excel..."); }
}

class RelatorioCSV implements Relatorio {
    @Override
    public void gerar() { System.out.println("Gerando relatório em formato CSV..."); }
}

// 3. A Fábrica (Isola a lógica de criação - Padrão de Criação)
class RelatorioFactory {
    public static Relatorio criarRelatorio(String tipo) {
        if (tipo.equalsIgnoreCase("PDF")) {
            return new RelatorioPDF();
        } else if (tipo.equalsIgnoreCase("EXCEL")) {
            return new RelatorioExcel();
        } else if (tipo.equalsIgnoreCase("CSV")) {
            return new RelatorioCSV();
        }
        throw new IllegalArgumentException("Formato de relatório não suportado: " + tipo);
    }
}

// 4. O Cliente Refatorado (Baixo Acoplamento)
public class GeradorDeRelatorios {
    
    public void exportar(String tipo) {
        // O Gerador agora não sabe COMO o relatório é criado.
        // Ele apenas pede para a fábrica e executa a interface.
        try {
            Relatorio relatorio = RelatorioFactory.criarRelatorio(tipo);
            relatorio.gerar();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        GeradorDeRelatorios gerador = new GeradorDeRelatorios();
        gerador.exportar("PDF");
        gerador.exportar("CSV"); // Testando a nova implementação facilmente adicionada
    }
}
