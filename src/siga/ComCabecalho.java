package siga;

import java.util.ArrayList;
import java.util.List;

public class ComCabecalho extends DecoradorRelatorio {

    public ComCabecalho(Relatorio relatorioDecorado) {
        super(relatorioDecorado);
    }

    @Override
    public List<String> gerar() {
        List<String> linhas = new ArrayList<>();
        linhas.add("========================================");
        linhas.add("  FATEC PORTO FERREIRA - SIGA");
        linhas.add("========================================");
        linhas.addAll(super.gerar());
        return linhas;
    }
}