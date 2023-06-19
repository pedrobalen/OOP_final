package trabalho;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Servidor {
    private static final int PORTA = 12345;
    private CadastroProduto cadastro;

    public Servidor() {
        cadastro = new CadastroProduto();
    }

    public void iniciar() {
        System.out.println("Rodando...");
        try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
            while (true) {
                try (
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                ) {
                    String inputLine = in.readLine();
                    StringTokenizer st = new StringTokenizer(inputLine);
                    int codigo = Integer.parseInt(st.nextToken());
                    int quantidade = Integer.parseInt(st.nextToken());

                    Produto produto = cadastro.buscarProduto(codigo);
                    if (produto == null) {
                        out.println("Erro: Produto não encontrado.");
                    } else if (produto.getEstoqueDisponivel() < quantidade) {
                    	out.println("Erro: Estoque insuficiente.");
                    } else {
                        produto.vender(quantidade);
                        cadastro.salvarProdutos();
                        out.println("Venda realizada com sucesso.");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Servidor().iniciar();
    }
}
