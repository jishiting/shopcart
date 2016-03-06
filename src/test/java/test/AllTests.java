package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
	作者：jist
	时间：下午12:52:26
	操作：TODO（描述操作原因）
 **/
@RunWith(Suite.class)
@SuiteClasses({
	CommonToolsTest.class,
	DealCaseTest.class,
	ProductsItemsTest.class,
})
public class AllTests {


}
