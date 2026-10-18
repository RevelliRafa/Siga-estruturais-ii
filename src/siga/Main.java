package siga;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  SIGA — DEMONSTRAÇÃO DECORATOR E COMPOSITE");
        System.out.println("==================================================\n");

        // -------------------------------------------------------------
        // PARTE 1: DECORATOR
        // -------------------------------------------------------------
        System.out.println(">>> 1. DEMONSTRAÇÃO DO PADRÃO DECORATOR <<<\n");

        Relatorio relatorioBase = new RelatorioDeAlunos();

        // Pilha 1: Base -> Cabeçalho -> Numeração
        System.out.println("--- Pilha 1: Com Cabecalho e depois Numeracao ---");
        Relatorio pilha1 = new ComNumeracao(new ComCabecalho(relatorioBase));
        for (String linha : pilha1.gerar()) {
            System.out.println(linha);
        }

        // Pilha 2: Base -> Numeração -> Cabeçalho -> Marca d'água (ordem invertida)
        System.out.println("\n--- Pilha 2: Com Numeracao na base, depois Cabecalho e Marca d'Agua ---");
        Relatorio pilha2 = new ComMarcaDagua(new ComCabecalho(new ComNumeracao(relatorioBase)));
        for (String linha : pilha2.gerar()) {
            System.out.println(linha);
        }

        // -------------------------------------------------------------
        // PARTE 2: COMPOSITE
        // -------------------------------------------------------------
        System.out.println("\n\n>>> 2. DEMONSTRAÇÃO DO PADRÃO COMPOSITE <<<\n");

        // Montando módulos de nível 1 e 2 (estrutura original com 340h)
        Modulo grade = new Modulo("Estrutura Curricular DSM");

        Modulo semestre1 = new Modulo("1º Semestre");
        semestre1.adicionar(new Disciplina("Algoritmos e Lógica", 80));
        semestre1.adicionar(new Disciplina("Modelagem de Banco de Dados", 80));

        Modulo semestre2 = new Modulo("2º Semestre");
        semestre2.adicionar(new Disciplina("Engenharia de Software I", 60));
        semestre2.adicionar(new Disciplina("Estruturas de Dados", 80));
        semestre2.adicionar(new Disciplina("Sistemas Operacionais", 40));

        grade.adicionar(semestre1);
        grade.adicionar(semestre2);

        System.out.printf("Carga horária inicial (deve ser 340h): %dh%n%n", grade.getCargaHoraria());
        grade.imprimir(0);

        // Etapa 5: Prova do Composite com submódulo de 3º nível
        System.out.println("\n--- Adicionando Submódulo de 3º Nível (Trilha de Especialização) ---");
        Modulo trilhaSeguranca = new Modulo("Trilha: Segurança da Informação");
        trilhaSeguranca.adicionar(new Disciplina("Segurança em Aplicações Web", 40));
        trilhaSeguranca.adicionar(new Disciplina("Criptografia e Redes", 40));

        // Adiciona a trilha dentro do 2º semestre (3º nível de aninhamento)
        semestre2.adicionar(trilhaSeguranca);

        System.out.printf("Nova carga horária total: %dh%n%n", grade.getCargaHoraria());
        grade.imprimir(0);
    }
}