package carrinho;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import produto.Produto;

public class CarrinhoTeste {
	
	Carrinho carrinho;

	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}
	
	@Test
	public void testSomatorioItems() {
		Produto p1 = new Produto("Produto Teste 1", 100.0);
		carrinho.addItem(p1);
		carrinho.addItem(new Produto("Produto Teste 2", 50.0));
		carrinho.addItem(new Produto("Produto Teste 3", 25.0));	
		Integer qtdItens =  carrinho.getQtdeItems();
		Assertions.assertEquals(3, qtdItens);
	}
}
