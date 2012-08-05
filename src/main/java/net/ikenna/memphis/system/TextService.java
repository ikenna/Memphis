package net.ikenna.memphis.system;

import net.ikenna.memphis.model.PhoneEmail;

public interface TextService {
    void sendText(TextMessage message, PhoneEmail phoneNumber);
}
