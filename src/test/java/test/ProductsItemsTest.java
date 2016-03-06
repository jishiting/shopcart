package test;

import static org.junit.Assert.*;

import entity.ProductsItems;
import factory.IProducts;
import org.junit.Test;
import products.AlcoholProducts;

/**
 * 作者：jist 时间：下午04:35:22 操作：TODO（描述操作原因）
 **/
public class ProductsItemsTest {

	@Test
	public void testProductsItemsIntIProductsFloat() {

		IProducts products = (IProducts) new AlcoholProducts();
		ProductsItems pi = new ProductsItems(1, products, 2);
		assertTrue(pi.getSumPrice() == 2);
	}

}
