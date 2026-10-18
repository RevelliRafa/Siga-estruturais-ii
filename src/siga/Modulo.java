package siga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Modulo implements ItemCurricular {

    private final String nome;
    private final List<ItemCurricular> itens = new ArrayList<>();

    public Modulo(String nome) {
        this.nome = nome;
    }

    public void adicionar(ItemCurricular item) {
        itens.add(item);
    }

    public void remover(ItemCurricular item) {
        itens.remove(item);
    }

    public List<ItemCurricular> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getCargaHoraria() {
        int total = 0;
        for (ItemCurricular item : itens) {
            total += item.getCargaHoraria();
        }
        return total;
    }

    @Override
    public void imprimir(int nivel) {
        String indentacao = "  ".repeat(nivel);
        System.out.printf("%s+ %s (Total: %dh)%n", indentacao, nome, getCargaHoraria());
        for (ItemCurricular item : itens) {
            item.imprimir(nivel + 1);
        }
    }
}