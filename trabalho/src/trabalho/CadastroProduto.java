package trabalho;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

class CadastroProduto {
      private List<Produto> produtos;
      private static final String FILE_PATH = "bancoprodutos.txt";

      public CadastroProduto() {
        produtos = new ArrayList<>();
        carregarProdutos();
    }

      public void cadastrarProduto(int codigo, String descricao, double precoCusto, double precoVenda, int estoqueDisponivel) {
        Produto produto = new Produto(codigo, descricao, precoCusto, precoVenda, estoqueDisponivel);
        produtos.add(produto);
        salvarProdutos();
        System.out.println("Produto cadastrado com sucesso.");
    }

      public void alterarPrecoProduto(int codigo, double novoPrecoVenda) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produto.setPrecoVenda(novoPrecoVenda);
                salvarProdutos();
                System.out.println("Preço do produto alterado com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

      public void excluirProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtos.remove(produto);
                salvarProdutos();
                System.out.println("Produto excluído com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

       @SuppressWarnings("unchecked")
	private void carregarProdutos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            produtos = (List<Produto>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de produtos não encontrado. Será criado um novo arquivo ao salvar os produtos.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os produtos: " + e);
            }
        }

        public void salvarProdutos() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                oos.writeObject(produtos);
            } catch (IOException e) {
                System.out.println("Erro ao salvar os produtos: " + e);
            }
        }

        public void exibirProdutos() {
            if (produtos.isEmpty()) {
                System.out.println("Não há produtos cadastrados.");
            } else {
                System.out.println("Lista de Produtos:");
                for (Produto produto : produtos) {
                    System.out.println(produto);
                }
            }
        }
        
        public Produto buscarProduto(int codigo) {
            for (Produto produto : produtos) {
                if (produto.getCodigo() == codigo) {
                    return produto;
                }
            }
            return null;
        }


    }
    