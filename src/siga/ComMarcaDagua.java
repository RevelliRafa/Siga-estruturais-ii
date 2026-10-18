package siga;

public package siga;

import java.util.ArrayList;
import java.util.List;

public class ComMarcaDagua extends DecoradorRelatorio {

    public ComMarcaDagua(Relatorio relatorioDecorado) {
        super(relatorioDecorado);
    }

    @Override
    public List<String> gerar() {
        List<String> linhas = new ArrayList<>(super.gerar());
        linhas.add("[DOCUMENTO NÃO OFICIAL - CÓPIA DE TRABALHO]");
        return linhas;
    }
} {
    
}
