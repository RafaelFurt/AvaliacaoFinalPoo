import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import impl.Produto;
import impl.Vendas;
import impl.Exceções.ProdutoNãoEncontrado;
import impl.Exceções.ProdutoVendidoNãoEncontrado;

public class Sistemacopy {
    private static Scanner scanner = new Scanner(System.in);
    static List<Produto> produtos = new ArrayList<>();
    static List<Vendas> lista_venda = new ArrayList<>();
    static String buscar;
    
        
    public static void main(String[] args) throws Exception {

        boolean continuarExecutando = true;
        
        do {
            try {
                visualizarMenu();
                int opcao = lerOpcao();
                continuarExecutando = executarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante o Processo: " + e.getMessage());
                continuarExecutando = true;
            }
        } while (continuarExecutando);
    }
    private static boolean executarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 1: {
                cadastrarProduto();
                break;
            }
            case 2:{
                consultarProduto();
                break;
            }
            case 3:{
               listarProduto();
                break;
            }
            case 4:{
                vendasPeriodo();
                break;
            }
            case 5:{
                realizarVendas();
                break;
            }
            case 6: {
                System.out.println("Saindo do sistema...");
                return false;
            }
            default: {
                System.out.println("Não disponível");
                break;
            }
        }

        return true;
    }
    private static void cadastrarProduto(){
        System.out.println("Digite o código do produto");
        String codigoProduto = scanner.nextLine();
        System.out.println("Digite o nome do produto");
        String nomeProduto = scanner.nextLine();
        System.out.println("Digite o valor do produto");
        Double valorProduto = scanner.nextDouble();
        System.out.println("Digite a quantidade de produto");
        int quantidadeEstoque = scanner.nextInt();

        Produto produto = new Produto(codigoProduto, nomeProduto, valorProduto, quantidadeEstoque);
        produtos.add(produto);
        System.out.println("Produto cadastrato com sucesso!");
        System.out.println("\n");
        scanner.nextLine();   
    }

    private static Produto consultarProduto()throws ProdutoNãoEncontrado{
        System.out.println("Informe o Código do Produto: ");
        buscar = scanner.nextLine();
        System.out.println("\n");
        for(Produto produto: produtos){
            if(produto != null && produto.get_codigoProduto().equals(buscar)){
                System.out.printf("%s %20s %20s %23s\n", "CODIGO", "NOME", "VALOR","QUANTIDADE");
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.printf("%s %25s %21s %18s\n", produto.get_codigoProduto(), produto.get_nomeProduto(), produto.get_valorProduto(), produto.get_quantidadeEstoque() );
            ;   System.out.println("\n");
                return(produto);
            }
        } throw new ProdutoNãoEncontrado(null);
    }
    private static void listarProduto(){                  
            System.out.println("Listagem de produtos:\n");
            System.out.printf("%s %20s %20s %23s\n", "CODIGO", "NOME", "VALOR","QUANTIDADE");
            System.out.println("-------------------------------------------------------------------------------------");
            for (Produto produto: produtos)  {
                System.out.printf( "%s %25s %21s %18s\n", produto.get_codigoProduto(), produto.get_nomeProduto(), produto.get_valorProduto(), produto.get_quantidadeEstoque() );
            }
            DoubleSummaryStatistics resumo = produtos.stream()
            .collect(Collectors.summarizingDouble(Produto::get_valorProduto));
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------RESUMO------------------------------------------");
            System.out.printf("Menor valor: %s - Maior Valor: %S\n ", resumo.getMin(), resumo.getMax());
            System.out.printf("Valor Médio: %.0f", resumo.getAverage());
            System.out.println("\n");
            
        }

    private static Vendas realizarVendas()throws ProdutoVendidoNãoEncontrado{
        System.out.println("Qual código do produto que irá vender: "); 
        String produtoVendido = scanner.nextLine(); 
        for(Produto Produto: produtos) {              
        if(Produto != null && Produto.get_codigoProduto().equals(produtoVendido) ){
            System.out.println("Qual a data da venda: "); 
            String datavenda = scanner.nextLine();
            System.out.println("Qual a quantidade vendida: "); 
            int quantidadeVendida = scanner.nextInt();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
            LocalDate dataVenda = LocalDate.parse(datavenda, dtf);
            Double valorVenda = Produto.get_valorProduto()*quantidadeVendida;
            Vendas vendas = new Vendas(dataVenda, produtoVendido, quantidadeVendida,valorVenda);
            lista_venda.add(vendas);
            System.out.println("Venda realizada com sucesso! "); 
            scanner.nextLine();   
            return(vendas);
        }   
        throw new ProdutoVendidoNãoEncontrado(produtoVendido);
    }
        return null;
    }

    private static Vendas vendasPeriodo(){
        System.out.println("Relatório de Vendas");
        System.out.println("Digite a data inícial:");
        String dataInicio = scanner.nextLine();
        System.out.println("Digite a data final:");
        String dataFim = scanner.nextLine();

        // definindo a formatação da data
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate dataInicioLocalDate = LocalDate.parse(dataInicio, dtf);
        LocalDate dataFimLocalDate = LocalDate.parse(dataFim, dtf);
        
        //Filtrando a lista de vendas pelo período
        DoubleSummaryStatistics resumovenda = lista_venda.stream()
        .filter( venda-> 
        venda.get_dataVenda().compareTo(dataInicioLocalDate) > -1 
            && venda.get_dataVenda().compareTo(dataFimLocalDate) < 1 )
        .collect(Collectors.summarizingDouble(Vendas::get_valorVendas));
        System.out.println("--------------------------------VENDAS POR PERÍODO------------------------------------");
        System.out.printf("%7s %20s %20s %20s\n", "DATA VENDA", "PRODUTO", "QUANTIDADE","VALOR");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Vendas venda : lista_venda) {
            System.out.printf( "%7s %20s %20s %20s\n",venda.get_dataVenda(), venda.get_produtoVendido(), venda.get_quantidadeVendida(), venda.get_valorVendas());
            }
        System.out.println("-----------------------------------RESUMO-----------------------------------------");
        System.out.printf( "Menor valor %s - Média de valor %s - Maior valor %s\n",resumovenda.getMin(), resumovenda.getAverage(),resumovenda.getMax());
        return null;
        
    }
    private static void visualizarMenu(){

        System.out.println("1. Incluir Produto");
        System.out.println("2. Consultar Produto");
        System.out.println("3. Listagem de Produtos");
        System.out.println("4. Vendas por Período");
        System.out.println("5. Realizar Venda");
        System.out.println("6. Sair");
    }
    private static boolean validarMenu(int opcao) {
        return (opcao >= 1  && opcao <= 6);
    }
    private static int lerOpcao() {
        int opcao = 0;
        do {
            System.out.println("Selecione a opção desejada: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (!validarMenu(opcao)) {
                    System.out.println("Opção inválida!");
                }
            }catch ( Exception e ) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
            }
        } while (!validarMenu(opcao));

        return opcao;
    } 


    
}            

