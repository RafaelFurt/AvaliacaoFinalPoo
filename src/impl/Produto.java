package impl;

public class Produto {
    
    private String _codigoProduto;
    private String _nomeProduto;
    private Double _valorProduto;
    private int _quantidadeEstoque;

    public Produto(String codigoProduto, String nomeProduto, double valorProduto, int quantidadeEstoque) {
        _nomeProduto = nomeProduto;
        _codigoProduto = codigoProduto;
        _valorProduto = valorProduto;
        _quantidadeEstoque = quantidadeEstoque;
    }

    public String get_codigoProduto() {
        return _codigoProduto;
    }

    public void set_codigoProduto(String _codigoProduto) {
        this._codigoProduto = _codigoProduto;
    }

    public String get_nomeProduto() {
        return _nomeProduto;
    }

    public void set_nomeProduto(String _nomeProduto) {
        this._nomeProduto = _nomeProduto;
    }

    public double get_valorProduto() {
        return _valorProduto;
    }

    public void set_valorProduto(double _valorProduto) {
        this._valorProduto = _valorProduto;
    }

    public int get_quantidadeEstoque() {
        return _quantidadeEstoque;
    }

    public void set_quantidadeEstoque(int _quantidadeEstoque) {
        this._quantidadeEstoque = _quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "ESTOQUE DE PRODUTOS \n \n Código: " + _codigoProduto + ", Nome: " + _nomeProduto + ", Quantidade: "
                + _quantidadeEstoque + ", Valor: R$ " + _valorProduto + "\n";
    }



}
