package com.datapar.mokito;

public class TrocaPedido {
	 
    private PedidoDao pedidoDao;
 
    public TrocaPedido(PedidoDao pedidoDao) {
        this.pedidoDao = pedidoDao;
    }
 
    public void trocar(Long codigoPedido) throws Exception {
        Pedido pedido = pedidoDao.obter(codigoPedido);
        if (StatusPedido.CANCELADO == pedido.getStatus()) {
            throw new Exception("Não é permitido realizar troca de um pedido cancelado");
        }
    }
}