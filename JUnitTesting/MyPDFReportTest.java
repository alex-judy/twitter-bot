package Test;

import org.junit.Test;
import org.junit.Assert;
import Utility.MyPDFReport;

public class MyPDFReportTest {
	
	//test to make sure if status does not return anything from query, then it will return NoData
	@Test
	public void IfNothingFound() throws Exception {
		Assert.assertEquals("No Data", MyPDFReport.CrimeDataZip("0000"));
	}
	

}
