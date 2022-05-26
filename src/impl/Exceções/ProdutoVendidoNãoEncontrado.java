package impl.Exceções;

public class ProdutoVendidoNãoEncontrado extends Exception{
    public ProdutoVendidoNãoEncontrado(String codigoProduto){
        super("Produto não econtrado: " + codigoProduto);
    }    
}
