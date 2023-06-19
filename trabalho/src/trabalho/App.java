package trabalho;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        CadastroProduto cadastro = new CadastroProduto();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Menu =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Alterar preço produto");
            System.out.println("3 - Excluir produto");
            System.out.println("4 - Exibir produtos");
            System.out.println("5 - Sair do sistema");
            System.out.println("Digite o número da opção desejada:");
            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Digite um número válido.");
                scanner.nextLine(); 
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Digite o código do produto:");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Digite a descrição do produto:");
                    String descricao = scanner.nextLine();

                    System.out.println("Digite o preço de custo do produto:");
                    double precoCusto = scanner.nextDouble();
                    scanner.nextLine(); 

                    System.out.println("Digite o preço de venda do produto:");
                    double precoVenda = scanner.nextDouble();
                    scanner.nextLine(); 

                    System.out.println("Digite o estoque disponível do produto:");
                    int estoqueDisponivel = scanner.nextInt();
                    scanner.nextLine(); 

                    cadastro.cadastrarProduto(codigo, descricao, precoCusto, precoVenda, estoqueDisponivel);
                    break;
                case 2:
                    System.out.println("Digite o código do produto:");
                    int codigoAlterar = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Digite o novo preço de venda do produto:");
                    double novoPrecoVenda = scanner.nextDouble();
                    scanner.nextLine(); 

                    cadastro.alterarPrecoProduto(codigoAlterar, novoPrecoVenda);
                    break;
                case 3:
                    System.out.println("Digite o código do produto:");
                    int codigoExcluir = scanner.nextInt();
                    scanner.nextLine(); 

                    cadastro.excluirProduto(codigoExcluir);
                    break;
                case 4:
                    cadastro.exibirProdutos();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Digite um número válido.");
            }
        }
    }

}
