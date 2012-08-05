package net.ikenna.memphis.system;

import net.ikenna.memphis.model.PhoneEmail;
import org.junit.Test;

public class CanSendTextMessagesTest {


    @Test
    public void testSendTextToAllMembersWithACertainTag() throws Exception {


        PhoneEmail phoneNumber1 = new PhoneEmail("789", "12345", "email1@email");
        PhoneEmail phoneNumber2 = new PhoneEmail("4567", "772345", "email2@email");
        TextMessage message = new TextMessage();
        Application application = new Application();

//        TransmissionReport report = application.getTextSystem().sendText(message, MemberTag.ALL);

//        assertEquals(report.get(1), "789, success")
    }
}
