package Test;

import org.junit.Test;
import org.junit.Assert;
import Utility.DateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtilTest {
	@Test
	public void TestIfDateNull(){
		Assert.assertEquals(null, DateUtil.convertToDate(null));

	}
	
	@Test(expected = ParseException.class)
	public void TestIfParseException(){
		DateUtil.convertToDate("wrong");
	}
	
	@Test
	public void TestIfDateCorrect(){
		Date testDate = new Date("06.04.1995");
		Assert.assertEquals(testDate, DateUtil.convertToDate("06.04.1995"));
	}
}
