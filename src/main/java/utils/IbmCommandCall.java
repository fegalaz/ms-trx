package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.CommandCall;

public final class IbmCommandCall {
	private static final Logger log = LoggerFactory.getLogger(IbmCommandCall.class);

	private IbmCommandCall() {

	}

	private static final String SERVER = "10.140.0.215";
	private static final String USER = "MXHV00";
	private static final String PASS = "Carabinero";

	public static String callVpan(String tarjetaEncriptada) {
		AS400 as400 = null;
		try {
			String commandStr = "VPAN " + tarjetaEncriptada;
			as400 = new AS400(SERVER, USER, PASS);

			CommandCall command = new CommandCall(as400);

			log.info("Executing: {}", commandStr);
			boolean success = command.run(commandStr);

			if (success) {
				log.info("Command Executed Successfully.");
			} else {
				log.info("Command Failed!");
			}

			log.info("Results: {}", command.getMessageList().length);
			AS400Message[] messageList = command.getMessageList();
			for (AS400Message message : messageList) {
				log.info(message.getText());
			}
			return command.getMessageList(0).getText();
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			try {
				if (as400 != null) {
					as400.disconnectAllServices();
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return tarjetaEncriptada;
	}
}
