package Factory;

import businessLogic.BLFacade;
import configuration.ConfigXML;

public interface factoryInterface {

	
	BLFacade services(ConfigXML c);
}
