package impl;
import java.time.LocalDate;

public class Vendas {
  
    private LocalDate _dataVenda;
    private String _produtoVendido;
    private int _quantidadeVendida;
    private double _valorVendas;



 public Vendas(LocalDate dataVenda, String produtoVendido, int quantidadeVendida, double valorVendas) {
        _dataVenda = dataVenda;
        _produtoVendido = produtoVendido;
        _quantidadeVendida = quantidadeVendida;
        _valorVendas = valorVendas;
    }

public LocalDate get_dataVenda() {
    return _dataVenda;
}

public void set_dataVenda(LocalDate _dataVenda) {
    this._dataVenda = _dataVenda;
}

public String get_produtoVendido() {
    return _produtoVendido;
}
public void set_produtoVendido(String _produtoVendido) {
    this._produtoVendido = _produtoVendido;
}
public int get_quantidadeVendida() {
    return _quantidadeVendida;
}
public void set_quantidadeVendida(int _quantidadeVendida) {
    this._quantidadeVendida = _quantidadeVendida;
}
public double get_valorVendas() {
    return _valorVendas;
}
public void set_valorVendas(double _valorVendas) {
    this._valorVendas = _valorVendas;
}
@Override
public String toString() {
    return "Vendas [_dataVenda=" + _dataVenda + ", _produtoVendido=" + _produtoVendido + ", _quantidadeVendida="
            + _quantidadeVendida + ", _valorVendas=" + _valorVendas + "]";
}
}