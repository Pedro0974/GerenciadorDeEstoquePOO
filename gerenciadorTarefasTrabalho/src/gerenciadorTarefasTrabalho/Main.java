package gerenciadorTarefasTrabalho;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(nome, senha);
        usuario.salvar("C:\\Users\\pedro\\eclipse-workspace\\gerenciadorTarefasTrabalho\\src\\gerenciadorTarefasTrabalho\\usuarios");

        ListaTarefas listaTarefas = new ListaTarefas(usuario);

        int opcao = 0;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Concluir tarefa");
            System.out.println("3 - Exibir tarefas pendentes");
            System.out.println("4 - Exibir tarefas concluídas");
            System.out.println("5 - Sair");

            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o título da tarefa: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();

                    LocalDate dataInicio = LocalDate.now();

                    listaTarefas.adicionarTarefa(titulo, descricao, dataInicio);

                    System.out.println("\nTarefa adicionada com sucesso.");
                    break;

                case 2:
                	listaTarefas.exibirTarefasPendentes();
                    System.out.print("\nDigite o índice da tarefa a ser concluída: ");
                    int indiceTarefaConcluida = scanner.nextInt();
                    scanner.nextLine();

                    listaTarefas.concluirTarefa(indiceTarefaConcluida);
                    
                    listaTarefas.exibirTarefasConcluidas();
                    System.out.println("\nTarefa concluída com sucesso.");
                    break;

                case 3:
                    System.out.println("\n--- Tarefas Pendentes ---");
                    listaTarefas.exibirTarefasPendentes();
                    break;

                case 4:
                    System.out.println("\n--- Tarefas Concluídas ---");
                    listaTarefas.exibirTarefasConcluidas();
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
}
