package test;

import static org.junit.Assert.*;

import entity.Coupon;
import entity.DiscountInformation;
import entity.ProductsItems;
import org.junit.Test;
import service.PackupObject;


/**
 * 作者：jist 时间：下午04:58:05 操作：TODO（描述操作原因）
 **/
public class DealCaseTest {

	@Test
	public void testPackupDiscountInformation() {

		String infor = "2013.11.11 | 0.7 | 电子";
		PackupObject dc = new PackupObject();
		DiscountInformation disInfor = dc.packupDiscountInformation(infor);
		assertTrue(null != disInfor.getProduct());

	}

	@Test
	public void testPackupProductsItems() {

		String infor = "1 * ipad : 2399.00";
		PackupObject dc = new PackupObject();
		ProductsItems pisInfor = dc.packupProductsItems(infor);
		assertTrue(null != pisInfor.getProducts());
	}

	@Test
	public void testPackupCoupon() {

		String infor = "2014.3.2 1000 200";
		PackupObject dc = new PackupObject();
		Coupon coupon = dc.packupCoupon(infor);
		assertTrue(null != coupon.getEffectiveDate());
	}

}
