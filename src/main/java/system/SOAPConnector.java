package system;

import country.GetCountryRequest;
import country.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPConnector extends WebServiceGatewaySupport {

    public GetCountryResponse callWebService(String url, GetCountryRequest request){
        return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}
