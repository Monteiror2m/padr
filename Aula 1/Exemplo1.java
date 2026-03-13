/*
Padrões de Criação (Ocultando a complexidade do new)
Objetivo: Mostrar aos alunos que instanciar classes diretamente com new espalha dependências pelo código. O padrão centraliza isso.

*/

// Código RUIM (Alto acoplamento)
// O cliente precisa saber exatamente qual classe instanciar.
Documento doc = new RelatorioPDF(); 

// ---------------------------------------------------------

// Código PADRONIZADO (Factory Method simplificado)
// O cliente pede um tipo, e a Fábrica decide como criar.
public class DocumentoFactory {
    public static Documento criarDocumento(String tipo) {
        if (tipo.equalsIgnoreCase("PDF")) {
            return new RelatorioPDF();
        } else if (tipo.equalsIgnoreCase("WORD")) {
            return new RelatorioWord();
        }
        throw new IllegalArgumentException("Tipo desconhecido");
    }
}

// Uso pelo cliente:
Documento doc = DocumentoFactory.criarDocumento("PDF");
