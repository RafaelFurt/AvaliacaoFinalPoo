package impl;
import java.time.LocalDate;

public class Vendas {
  
    private LocalDate dataVenda;
    private String produtoVendido;
    private int quantidadeVendida;

    public Vendas(LocalDate _dataVenda, String _produtoVendido, int _quantidadeVendida) {
        _dataVenda = dataVenda;
        _produtoVendido = produtoVendido;
        _quantidadeVendida = quantidadeVendida;
 }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    @Override
    public String toString() {
        return "Vendas [dataVenda=" + dataVenda + ", produtoVendido=" + produtoVendido + ", quantidadeVendida="
                + quantidadeVendida + "]";
    }
}