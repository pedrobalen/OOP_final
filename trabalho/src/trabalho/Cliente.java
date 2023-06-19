package trabalho;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private static final String ENDERECO_SERVIDOR = "localhost";
    private static final int PORTA = 12345;

    public static void main(String[] args) {
        try (
                Socket clientSocket = new Socket(ENDERECO_SERVIDOR, PORTA);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                Scanner sc = new Scanner(System.in);
        ) {
            while (true) {
                System.out.println("Digite o código do produto:");
                int codigo = sc.nextInt();
                System.out.println("Digite a quantidade:");
                int quantidade = sc.nextInt();

                out.println(codigo + " " + quantidade);

                String respostaServidor = in.readLine();
                System.out.println(respostaServidor);
            }
        } catch (IOException e) {
            System.out.println("Erro no cliente: " + e.getMessage());
        }
    }
}
