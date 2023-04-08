package gerenciadorTarefasTrabalho;

import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate dataInicio;
    private String status;

    public Tarefa(String titulo, String descricao, LocalDate dataInicio) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.status = "pendente";
    }

    // getters e setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}