package com.datapar.mokito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
 
import org.junit.Test;
 
public class TrocaPedidoTest {
 
    @Test(expected = Exception.class)
    public void deveOcorrerErroQuandoTentarTrocarPedidoCancelado() throws Exception {
        try {
            // Cria um mock para a interface de acesso a dados de pedido
            PedidoDao pedidoDao = mock(PedidoDao.class);
 
            // especifico o comportamento do mock
            Pedido pedido = new Pedido();
            pedido.setStatus(StatusPedido.CANCELADO);
 
            // Retornar o pedido acima quando o método "obter" for chamado para o id 777
            doReturn(pedido).when(pedidoDao).obter(new Long(777));
 
            TrocaPedido trocaPedido = new TrocaPedido(pedidoDao);
            trocaPedido.trocar(new Long(777));
            
        } catch (Exception e) {
        	
            assertTrue(e.getMessage().contains("Não é permitido realizar troca de um pedido cancelado!"));
            
            throw e;
        }
    }
}