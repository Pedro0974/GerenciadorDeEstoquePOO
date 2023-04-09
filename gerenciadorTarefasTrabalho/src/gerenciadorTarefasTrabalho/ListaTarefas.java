package gerenciadorTarefasTrabalho;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListaTarefas {
	private ArrayList<Tarefa> tarefasPendentes;
	private ArrayList<Tarefa> tarefasConcluidas;
	private Usuario usuario;

	public ListaTarefas(Usuario usuario) {
		this.tarefasPendentes = new ArrayList<>();
		this.tarefasConcluidas = new ArrayList<>();
		this.usuario = usuario;

	}

	public void adicionarTarefa(String titulo, String descricao, LocalDate dataInicio) {
		Tarefa tarefa = new Tarefa(titulo, descricao, dataInicio);
		this.tarefasPendentes.add(tarefa);

		this.salvarTarefas();
	}

	public void concluirTarefa(int index) {
		Tarefa tarefa = this.tarefasPendentes.remove(index);
		tarefa.setStatus("concluida");
		this.tarefasConcluidas.add(tarefa);
		
		this.salvarTarefas();
	}

	public void salvarTarefas() {
		try {
			// Cria arquivo para tarefas pendentes
			FileWriter writerPendentes = new FileWriter(this.usuario.getNome() + "_pendentes.txt");

			for (Tarefa tarefa : this.tarefasPendentes) {
				writerPendentes.write("Título: " + tarefa.getTitulo() + "\n");
				writerPendentes.write("Descrição: " + tarefa.getDescricao() + "\n");
				writerPendentes.write("Data de início: " + tarefa.getDataInicio() + "\n");
				writerPendentes.write("Status: " + tarefa.getStatus() + "\n");
				writerPendentes.write("\n");
			}

			writerPendentes.close();

			// Cria arquivo para tarefas concluídas
			FileWriter writerConcluidas = new FileWriter(this.usuario.getNome() + "_concluidas.txt");

			for (Tarefa tarefa : this.tarefasConcluidas) {
				writerConcluidas.write("Título: " + tarefa.getTitulo() + "\n");
				writerConcluidas.write("Descrição: " + tarefa.getDescricao() + "\n");
				writerConcluidas.write("Data de início: " + tarefa.getDataInicio() + "\n");
				writerConcluidas.write("Status: " + tarefa.getStatus() + "\n");
				writerConcluidas.write("\n");
			}

			writerConcluidas.close();

		} catch (IOException e) {
			System.out.println("Erro ao salvar as tarefas.");
			e.printStackTrace();
		}
	}
	


	public void exibirTarefasPendentes() {
		System.out.println("Tarefas pendentes:");

		if (this.tarefasPendentes.isEmpty()) {
			System.out.println("Nenhuma tarefa pendente.");
		} else {
			for (Tarefa tarefa : this.tarefasPendentes) {
				System.out.println("Título: " + tarefa.getTitulo());
				System.out.println("Descrição: " + tarefa.getDescricao());
				System.out.println("Data de início: " + tarefa.getDataInicio());
				System.out.println("Status: " + tarefa.getStatus());
				System.out.println();
			}
		}
	}

	public void exibirTarefasConcluidas() {
		System.out.println("Tarefas concluídas:");

		if (this.tarefasConcluidas.isEmpty()) {
			System.out.println("Nenhuma tarefa concluída.");
		} else {
			for (Tarefa tarefa : this.tarefasConcluidas) {
				System.out.println("Título: " + tarefa.getTitulo());
				System.out.println("Descrição: " + tarefa.getDescricao());
				System.out.println("Data de início: " + tarefa.getDataInicio());
				System.out.println("Status: " + tarefa.getStatus());
				System.out.println();
			}
		}
	}
}
