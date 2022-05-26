package impl.Exceções;

public class ProdutoNãoEncontrado extends Exception {
    public ProdutoNãoEncontrado(String codigoProduto){
        super("Produto não econtrado: " + codigoProduto);
    }
    
}
