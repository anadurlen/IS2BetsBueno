package Factory;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataaccess.DataAccess;

public class factory implements factoryInterface{
	
	@Override
	public 	BLFacade services(ConfigXML c) {
	
	
	if (c.isBusinessLogicLocal()) {
		
		//In this option the DataAccess is created by FacadeImplementationWS
		//appFacadeInterface=new BLFacadeImplementation();

		//In this option, you can parameterize the DataAccess (e.g. a Mock DataAccess object)
		System.out.println("aqui probando que local");
		DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
		return new BLFacadeImplementation(da);

		
	} else { //If remote
		
		System.out.println("aqui probando que service sofroror");
		String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
		 
		//URL url = new URL("http://localhost:9999/ws/ruralHouses?wsdl");
		URL url;
		try {
			url = new URL(serviceName);
			QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
			Service service = Service.create(url, qname);
			return service.getPort(BLFacade.class );
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 

 
        //1st argument refers to wsdl document above
		//2nd argument is service name, refer to wsdl document above
//        QName qname = new QName("http://businessLogic/", "FacadeImplementationWSService");
        
         
	} 

}
}
