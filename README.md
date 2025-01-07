# Inventário de Produtos

## Descrição

Uma aplicação Java para gerenciar um inventário de produtos.

Funcionalidades principais:

- Adicionar produtos ao inventário
- Listar todos os produtos com opções de filtro e ordenação
- Atualizar informações de produtos existentes
- Excluir produtos
- Consultar produtos por ID ou nome

## Tecnologias Utilizadas

- **Java**: Linguagem principal da aplicação

## Requisitos

- **Java 11** ou superior instalado no seu computador
- Um editor ou IDE como IntelliJ IDEA, Eclipse, ou VS Code com extensão para Java

## Como Rodar a Aplicação Localmente

1. **Clone ou Baixe o Repositório**

   - Clone o repositório do projeto ou baixe os arquivos localmente.

2. **Compile os Arquivos Java**

   - Abra um terminal na pasta raiz do projeto.
   - Compile os arquivos Java usando o seguinte comando:
     ```bash
     javac -d bin src/*.java
     ```
     Isso criará os arquivos compilados na pasta `bin`.

3. **Execute o Programa**

   - Rode o arquivo principal (ex.: `Main.java`) com o seguinte comando:
     ```bash
     java -cp bin Main
     ```

4. **Interaja com o Menu**

   - O programa apresentará opções no menu. Basta digitar o número correspondente à funcionalidade desejada.

## Estrutura do Projeto

```
.
├── src/
│   ├── Main.java         # Arquivo principal para inicializar o programa
│   ├── Model.java        # Classe que representa o produto
│   ├── Controller.java   # Controlador para gerenciar operações no inventário
│   ├── Interface.java    # Classe para gerenciar interação com o usuário via Scanner
├── bin/                  # Arquivos compilados (gerados após a compilação)
├── README.md             # Este arquivo de instruções
```

## Exemplo de Execução

### Menu Inicial:

```
Bem-vindo ao Sistema de Inventário de Produtos!
Escolha uma opção:
1. Adicionar Produto
2. Atualizar Produto
3. Consultar Produto
4. Excluir Produto
5. Listar Produtos
6. Sair
```

Digite o número da opção desejada para navegar pelo sistema.

