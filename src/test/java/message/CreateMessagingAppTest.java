package message;

import org.testng.annotations.Test;
import com.nitin.qa.sampleProject.modules.messaging.MessageBase;


public class CreateMessagingAppTest extends MessageBase  {
	
	@Test
	public void sendSmsTest() throws Exception {
		sendSms();
		sendEmail();
		log("Test case completed");
	}

}
