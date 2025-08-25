package carrinho;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
    Carrinho carrinho;
    Produto livro;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        livro = new Produto("produto1", 100.00);
        carrinho.addItem(livro);
    }

    @Test
    public void TestaValorTotal(){
        double total = carrinho.getValorTotal();

        Assertions.assertEquals(total, livro.getPreco());
    }

    @Test
    public void TestQtdItens(){
        Produto livro2 = new Produto("produto2", 100.00);
        carrinho.addItem(livro2);

        Assertions.assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    public void TestRemoverItens() {
        try {
            carrinho.removeItem(livro);
        } catch (ProdutoNaoEncontradoException e) {
            Assertions.fail("Produto não encontrado ao tentar remover do carrinho.");
        }

        Assertions.assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    public void TestEsvaziaCarrinho() {
        carrinho.esvazia();

        Assertions.assertEquals(0, carrinho.getQtdeItems());
    }
}
