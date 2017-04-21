package Test;

import Utility.DropBox;
import org.junit.Test;

import com.dropbox.core.DbxException;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;

public class DropBoxTest {
	@Test
	public void SendNoData() throws DbxException{
		Assert.assertEquals("No Data", DropBox.getLink("No Data"));
	}
	
	@Test
	public void SendInvalidFileName()throws DbxException{
		Assert.assertEquals("No Data", DropBox.getLink("Something"));
	}

}
