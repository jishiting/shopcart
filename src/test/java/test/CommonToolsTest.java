package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.CommonTools;
import factory.IProducts;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import products.AlcoholProducts;
import products.DailyNecessityesProducts;


/**
 * 作者：jist 时间：下午04:12:20 操作：TODO（描述操作原因）
 **/
public class CommonToolsTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testCheckDiscountInformationInput() {

		String str = "2013.11.11 | 0.7 | 电子";
		assertTrue(CommonTools.checkDiscountInformationInput(str));
	}

	@Test
	public void testCheckProductsItemsInput() {

		String str = "1 * ipad : 2399.00 ";
		assertTrue(CommonTools.checkProductsItemsInput(str));
		str = "1 * 显示器 : 1799.00";
		assertTrue(CommonTools.checkProductsItemsInput(str));
		str = "8 * 餐巾纸 : 3.20";
		assertTrue(CommonTools.checkProductsItemsInput(str));
	}

	@Test
	public void testCheckCouponInput() {

		String str = "2014.3.2 1000 200 ";
		assertTrue(CommonTools.checkCouponInput(str));
		str = "2014.3.2 1000 200";
		assertTrue(CommonTools.checkCouponInput(str));
	}

	@Test
	public void testFormattedResult() {

		Assert.assertEquals("23.25", CommonTools.formattedResult(23.246));
		Assert.assertEquals("23.25", CommonTools.formattedResult(23.252));
	}

	@Test
	public void testwhetherExpired() {

		try {
			Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse("2013-11-22");
			Date date2 = new SimpleDateFormat("yyyy-mm-dd").parse("2013-11-23");
			Date date3 = new SimpleDateFormat("yyyy-mm-dd").parse("2013-11-24");
			Date date4 = new SimpleDateFormat("yyyy-mm-dd").parse("2013-11-22");
			assertTrue(CommonTools.whetherExpired(date2, date1));
			assertFalse(CommonTools.whetherExpired(date2, date3));
			assertTrue(CommonTools.whetherExpired(date4, date1));
			
		} catch (ParseException e) {
			throw new IllegalArgumentException("输入格式不对");
		}

	}

	@Test
	public void testcheckDeadlineInput() {

		String productsItemsInput = "2013.11.11";
		assertTrue(CommonTools.checkDeadlineInput(productsItemsInput));
		productsItemsInput = "2013.11.1s1";
		assertFalse(CommonTools.checkDeadlineInput(productsItemsInput));

	}

	@Test
	public void testReadProterties() {

		assertTrue(AlcoholProducts.ELECTRONICPRODUCTS.equals(CommonTools
				.readProterties("ipad")));

		assertTrue(AlcoholProducts.DAILYNECESSITYESPRODUCTS.equals(CommonTools
				.readProterties("餐巾纸")));
	}

	@Test
	public void testGetProductType() {

		IProducts products = new AlcoholProducts();
		String xx = CommonTools.getProductType(products);
		assertEquals(IProducts.ALCOHOLPRODUCTS, xx);
		products = new DailyNecessityesProducts();
		xx = CommonTools.getProductType(products);
		assertEquals(IProducts.DAILYNECESSITYESPRODUCTS, xx);
		assertFalse(IProducts.ALCOHOLPRODUCTS.equals(xx));
	}
}
