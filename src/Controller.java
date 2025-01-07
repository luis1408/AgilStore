package src;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

public class Controller implements Interface{
    
    public ArrayList<Model> adicionar(ArrayList<Model> listaProduto) {
       
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite a categoria do produto:");
        String categoria = scanner.nextLine();
        System.out.println("Digite a quantidade do produto:");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        int preco = scanner.nextInt();
        scanner.nextLine();

        Model novoProduto = new Model(nome, categoria,  quantidade, preco);
        listaProduto.add(novoProduto);
        System.out.println("Produto adicionado: " + novoProduto);
        return listaProduto;
    }

    public ArrayList<Model> atualizar(ArrayList<Model> listaProduto) {
        System.out.println("Digite o ID do produto que deseja atualizar:");
        String idInput = scanner.nextLine();

        try {
            UUID id = UUID.fromString(idInput);

            for (Model produto : listaProduto) {
                if (produto.getId().equals(id)) {
                    System.out.println("Produto encontrado: " + produto);

                    boolean continuar = true;
                    while (continuar) {
                        System.out.println("Quais informações deseja atualizar?");
                        System.out.println("1. Nome");
                        System.out.println("2. Categoria");
                        System.out.println("3. Quantidade");
                        System.out.println("4. Preço");
                        System.out.println("0. Sair");

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                            case 1:
                                System.out.println("Digite o novo nome:");
                                String novoNome = scanner.nextLine();
                                if (!novoNome.isBlank()) {
                                    produto.setNome(novoNome);
                                    System.out.println("Nome atualizado com sucesso.");
                                } else {
                                    System.out.println("Nome inválido!");
                                }
                                break;

                            case 2:
                                System.out.println("Digite a nova categoria:");
                                String novaCategoria = scanner.nextLine();
                                if (!novaCategoria.isBlank()) {
                                    produto.setCategoria(novaCategoria);
                                    System.out.println("Categoria atualizada com sucesso.");
                                } else {
                                    System.out.println("Categoria inválida!");
                                }
                                break;

                            case 3:
                                System.out.println("Digite a nova quantidade:");
                                int novaQuantidade = scanner.nextInt();
                                if (novaQuantidade >= 0) {
                                    produto.setQuantidade(novaQuantidade);
                                    System.out.println("Quantidade atualizada com sucesso.");
                                } else {
                                    System.out.println("Quantidade inválida!");
                                }
                                break;

                            case 4:
                                System.out.println("Digite o novo preço:");
                                int novoPreco = scanner.nextInt();
                                if (novoPreco >= 0) {
                                    produto.setPreco(novoPreco);
                                    System.out.println("Preço atualizado com sucesso.");
                                } else {
                                    System.out.println("Preço inválido!");
                                }
                                break;

                            case 0:
                                continuar = false;
                                System.out.println("Atualização concluída.");
                                break;

                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    }

                    System.out.println("Produto final atualizado: " + produto);
                    return listaProduto;
                }
            }

            System.out.println("Produto com ID " + id + " não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.println("ID inválido! Certifique-se de fornecer um UUID válido.");
        }

        return listaProduto;
    }


    public void consultar(ArrayList<Model> listaProduto) {
        System.out.println("Como deseja buscar o produto?");
        System.out.println("1. Por ID");
        System.out.println("2. Por Nome");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcao) {
            case 1: 
                System.out.println("Digite o ID do produto:");
                String idInput = scanner.nextLine();

                try {
                    UUID id = UUID.fromString(idInput);
                    boolean encontrado = false;

                    for (Model produto : listaProduto) {
                        if (produto.getId().equals(id)) {
                            System.out.println("Produto encontrado:");
                            System.out.println(produto);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Nenhum produto com o ID informado foi encontrado.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("ID inválido! Certifique-se de fornecer um UUID válido.");
                }
                break;

            case 2: // Busca por Nome
                System.out.println("Digite parte do nome do produto:");
                String nomeInput = scanner.nextLine().toLowerCase();
                boolean encontradoNome = false;

                for (Model produto : listaProduto) {
                    if (produto.getNome().toLowerCase().contains(nomeInput)) {
                        if (!encontradoNome) {
                            System.out.println("Produtos encontrados:");
                        }
                        System.out.println(produto);
                        encontradoNome = true;
                    }
                }

                if (!encontradoNome) {
                    System.out.println("Nenhum produto com o nome informado foi encontrado.");
                }
                break;

            default:
                System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
        }
    }

    public ArrayList<Model> remover(ArrayList<Model> listaProduto) {
        System.out.println("Digite o ID do produto que deseja remover:");
        String idInput = scanner.nextLine();

        try {
            UUID id = UUID.fromString(idInput);

            for (Model produto : listaProduto) {
                if (produto.getId().equals(id)) {
                    System.out.println("Tem certeza que deseja remover " + produto + "de seu catálogo? (responda com sim ou não)");
                    String simOuNao = scanner.nextLine();
                    if (simOuNao.equalsIgnoreCase("sim")) {
                        listaProduto.remove(produto);
                        System.out.println("Produto removido com sucesso.");
                    } else {
                        System.out.println("Ação de exclusão cancelada.");
                    }
                    return listaProduto;
                }
            }

            System.out.println("Produto com ID " + id + " não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.println("ID inválido! Certifique-se de fornecer um UUID válido.");
        }

        return listaProduto;
    }

    public void listar(ArrayList<Model> listaProduto) {
        if (listaProduto.isEmpty()) {
            System.out.println("Nenhum produto cadastrado no inventário.");
            return;
        }

        System.out.println("Deseja aplicar algum filtro ou ordenação?");
        System.out.println("1. Sem filtros (mostrar todos)");
        System.out.println("2. Filtrar por Categoria");
        System.out.println("3. Ordenar por Nome");
        System.out.println("4. Ordenar por Quantidade");
        System.out.println("5. Ordenar por Preço");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Model> produtosFiltrados = new ArrayList<>(listaProduto);

        switch (opcao) {
            case 1:
                break;

            case 2:
                System.out.println("Digite a categoria para filtrar:");
                String categoria = scanner.nextLine().toLowerCase();
                produtosFiltrados.removeIf(produto -> !produto.getCategoria().toLowerCase().contains(categoria));
                break;

            case 3:
                produtosFiltrados.sort(Comparator.comparing(Model::getNome));
                break;

            case 4:
                produtosFiltrados.sort(Comparator.comparingInt(Model::getQuantidade));
                break;

            case 5:
                produtosFiltrados.sort(Comparator.comparingDouble(Model::getPreco));
                break;

            default:
                System.out.println("Opção inválida. Exibindo todos os produtos sem filtros.");
        }

        if (produtosFiltrados.isEmpty()) {
            System.out.println("Nenhum produto encontrado para os critérios selecionados.");
        } else {
            // Exibe tabela de produtos
            System.out.printf("%-36s %-20s %-15s %-10s %-10s%n", 
                "ID", "Nome do Produto", "Categoria", "Quantidade", "Preço");
            System.out.println("=".repeat(95));
            for (Model produto : produtosFiltrados) {
                System.out.printf("%-36s %-20s %-15s %-10d %-10.2f%n", 
                    produto.getId(), 
                    produto.getNome(), 
                    produto.getCategoria(), 
                    produto.getQuantidade(), 
                    produto.getPreco());
            }
        }
    }
}