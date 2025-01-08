package src;
import java.util.ArrayList;

public class Main implements Interface{
    public static void main(String[] args) {
        Controller controller = new Controller();
        ArrayList<Model> listaProduto = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu de Operações:");
            System.out.println("1. Adicionar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Remover");
            System.out.println("5. Buscar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    controller.adicionar(listaProduto);
                    break;
                case 2:
                    controller.listar(listaProduto);
                    break;
                case 3:
                    controller.atualizar(listaProduto);
                    break;
                case 4:
                    controller.remover(listaProduto);
                    break;
                case 5:
                    controller.consultar(listaProduto);
                    break;
                case 0:
                    System.out.println("Fechando do aplicação...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
