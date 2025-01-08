package src;
import java.util.UUID;

public class Model {
    private UUID id;
    private String nome;
    private String categoria;
    private int quantidade;
    private double preco;

    public Model(UUID id, String nome, String categoria,  int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %s\nNome: %s\nCategoria: %s\nQuantidade: %d\nPreço: %.2f",
            id, nome, categoria, quantidade, preco
        );
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
