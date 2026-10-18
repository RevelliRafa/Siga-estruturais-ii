package siga;

public package siga;

import java.util.ArrayList;
import java.util.List;

public class ComNumeracao extends DecoradorRelatorio {

    public ComNumeracao(Relatorio relatorioDecorado) {
        super(relatorioDecorado);
    }

    @Override
    public List<String> gerar() {
        List<String> originais = super.gerar();
        List<String> numeradas = new ArrayList<>();
        int i = 1;
        for (String linha : originais) {
            numeradas.add(String.format("%02d. %s", i++, linha));
        }
        return numeradas;
    }
} {
    
}
