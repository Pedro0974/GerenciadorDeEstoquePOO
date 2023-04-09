package gerenciadorTarefasTrabalho;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Usuario {
    private String nome;
    private String senha;
    
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public void salvar(String caminho) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(caminho + "/" + this.nome + "_pendentes.txt"));
            writer.write(this.nome + "\n" + this.senha);
            writer.close();
            System.out.println("Usuário salvo com sucesso em " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

	public String getNome() {
		return nome;
	}
}

