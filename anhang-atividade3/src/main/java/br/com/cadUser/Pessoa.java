package br.com.cadUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named // Anotação CDI: torna esta classe um bean gerenciado, acessível via Expression Language
@RequestScoped // Anotação CDI: define o escopo do bean para a duração da requisição HTTP
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome; // Atributo para o nome digitado no formulário
    private List<String> nomesCadastrados; // ArrayList para armazenar os nomes

    @PostConstruct // Método executado após a construção do bean
    public void init() {
        // Inicializa o ArrayList quando o bean é criado
        nomesCadastrados = new ArrayList<>();
    }

    // Método de ação para adicionar o nome à lista
    public void adicionarNome() {
        if (this.nome != null && !this.nome.trim().isEmpty()) {
            nomesCadastrados.add(this.nome);
            this.nome = ""; // Limpa o campo após adicionar
        }
    }

    // --- Métodos Getters e Setters para 'nome' ---
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // --- Método Getter para 'nomesCadastrados' ---
    // O JSF usará este getter para exibir a lista na tela
    public List<String> getNomesCadastrados() {
        return nomesCadastrados;
    }
}