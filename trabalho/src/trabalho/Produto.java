package trabalho;

import java.io.Serializable;

class Produto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
    private String descricao;
    private double precoCusto;
    private double precoVenda;
    private int estoqueDisponivel;

    public Produto(int codigo, String descricao, double precoCusto, double precoVenda, int estoqueDisponivel) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.estoqueDisponivel = estoqueDisponivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }
    
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

    public int getEstoqueDisponivel() {
        return estoqueDisponivel;
    }
    
    public void vender(int quantidade) {
        if (quantidade <= estoqueDisponivel) {
            estoqueDisponivel -= quantidade;
            System.out.println("Venda realizada com sucesso.");
        } else {
            System.out.println("Estoque insuficiente.");
        }
    }



    @Override
    public String toString() {
        return "Produto{" +
                "codigo = " + codigo +
                ", descricao ='" + descricao + '\'' +
                ", preco de custo = " + precoCusto +
                ", preco de venda = " + precoVenda +
                ", estoque disponivel = " + estoqueDisponivel +
                '}';
    }


}
