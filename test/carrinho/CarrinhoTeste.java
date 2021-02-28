package carrinho;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTeste {

	Carrinho carrinho;

	@BeforeEach
	public void inicializa() {

	}

	@Test
	public void testSomatorioItems() {
		carrinho = new Carrinho();
		Produto p1 = new Produto("Produto Teste 1", 100.0);
		carrinho.addItem(p1);
		carrinho.addItem(new Produto("Produto Teste 2", 50.0));
		carrinho.addItem(new Produto("Produto Teste 3", 25.0));
		Integer qtdItens = carrinho.getQtdeItems();
		Assertions.assertEquals(3, qtdItens);
	}

	@Test
	public void testaValorTotal() {
		carrinho = new Carrinho();
		carrinho.addItem(new Produto("Produto Teste 1", 100.0));
		carrinho.addItem(new Produto("Produto Teste 2", 100.0));
		carrinho.addItem(new Produto("Produto Teste 3", 100.0));
		carrinho.addItem(new Produto("Produto Teste 4", 100.0));
		carrinho.addItem(new Produto("Produto Teste 5", 100.0));
		Double valorTotalCarrinho = carrinho.getValorTotal();
		assertEquals(500.0, valorTotalCarrinho);
	}

	@Test
	public void testaRemocaoCarrinho() throws ProdutoNaoEncontradoException {
		Produto p1 = new Produto("Produto Muito Vendido", 1.0);
		carrinho = new Carrinho();
		carrinho.addItem(p1);

		carrinho.removeItem(p1);

		assertEquals(0, carrinho.getQtdeItems());
	}

	@Test
	public void testaRemocaoProdutoInexistente() {
		Produto p2 = new Produto("Produto Muito Vendido 2", 1.0);
		carrinho = new Carrinho();
		Assertions.assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(p2));
	}

	@Test
	public void testaLimpezaLista() {
		carrinho = new Carrinho();
		carrinho.addItem(new Produto("Produto Muito Vendido", 1.0));
		carrinho.esvazia();
		Assertions.assertEquals(0, carrinho.getQtdeItems());
	}
}
