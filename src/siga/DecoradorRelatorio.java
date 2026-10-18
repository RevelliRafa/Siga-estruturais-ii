package siga;

import java.util.List;

public abstract class DecoradorRelatorio implements Relatorio {

    protected final Relatorio relatorioDecorado;

    public DecoradorRelatorio(Relatorio relatorioDecorado) {
        this.relatorioDecorado = relatorioDecorado;
    }

    @Override
    public List<String> gerar() {
        return relatorioDecorado.gerar();
    }
}