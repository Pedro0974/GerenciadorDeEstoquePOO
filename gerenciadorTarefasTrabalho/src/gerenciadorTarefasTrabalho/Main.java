package gerenciadorTarefasTrabalho;


import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(nome, senha);
        // Mude o caminho na hora de testar
        usuario.salvar("C:\\\\Users\\\\pedro\\\\eclipse-workspace\\\\gerenciadorTarefasTrabalho\\\\src\\\\gerenciadorTarefasTrabalho\\\\usuarios");

        ListaTarefas listaTarefas = new ListaTarefas(usuario);

        int opcao = 0;

        do {
            imprimirMenu();

            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarTarefa(listaTarefas);
                    break;

                case 2:
                    concluirTarefa(listaTarefas);
                    break;

                case 3:
                    exibirTarefasPendentes(listaTarefas);
                    break;

                case 4:
                    exibirTarefasConcluidas(listaTarefas);
                    break;

                case 5:
                    System.out.println("\nSaindo...");
                    break;

                default:
                    System.out.println("\nOpção inválida. Digite novamente.");
                    break;
            }
        } while (opcao != 5);

//        listaTarefas.salvarTarefas();
        scanner.close();
    }

    private static void imprimirMenu() {
        System.out.println("\n----- MENU -----");
        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Concluir tarefa");
        System.out.println("3 - Exibir tarefas pendentes");
        System.out.println("4 - Exibir tarefas concluídas");
        System.out.println("5 - Sair");
    }

    private static void adicionarTarefa(ListaTarefas listaTarefas) {
        System.out.print("\nDigite o título da tarefa: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();

        LocalDate dataInicio = LocalDate.now();

        listaTarefas.adicionarTarefa(titulo, descricao, dataInicio);

        System.out.println("\nTarefa adicionada com sucesso.");
    }

    private static void concluirTarefa(ListaTarefas listaTarefas) {
        exibirTarefasPendentes(listaTarefas);
        System.out.print("\nDigite o índice da tarefa a ser concluída: ");
        int indiceTarefaConcluida = scanner.nextInt();
        scanner.nextLine();

        listaTarefas.concluirTarefa(indiceTarefaConcluida);

        exibirTarefasConcluidas(listaTarefas);
        System.out.println("\nTarefa concluída com sucesso.");
    }

    private static void exibirTarefasPendentes(ListaTarefas listaTarefas) {
        System.out.println("\n--- Tarefas Pendentes ---");
        listaTarefas.exibirTarefasPendentes();
    }

    private static void exibirTarefasConcluidas(ListaTarefas listaTarefas) {
        System.out.println("\n--- Tarefas Concluídas ---");
        listaTarefas.exibirTarefasConcluidas();
    }
}

