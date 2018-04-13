package controller;

import country.GetCountryRequest;
import country.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import other.MyString;
import system.Config;
import system.SOAPConnector;

@Controller
public class MyController {

    @Autowired
    private SOAPConnector soapConnector;

    @GetMapping(value = "/")
    public String setCountry() {
        return "setcountry";
    }

    @PostMapping(value = "/getcountryinfo")
    public String getSearchingByAuthorForm(@RequestParam String countryName, Model model) {

        /*Config.name = "admin";
        Config.password = "admin";*/

        GetCountryRequest request = new GetCountryRequest();
        request.setName(countryName);
        GetCountryResponse response = soapConnector.callWebService("http://localhost:8080/ws", request);

        model.addAttribute("name", response.getCountry().getName());
        model.addAttribute("capital", response.getCountry().getCapital());
        model.addAttribute("population", response.getCountry().getCurrency());
        model.addAttribute("currency", response.getCountry().getPopulation());

        return "countryinfo";
    }

    @GetMapping(value = "/getstringjson", produces = "application/json")
    @ResponseBody
    public MyString getMyStringJson() {

        /*GetCountryRequest request = new GetCountryRequest();
        request.setName("Spain");
        GetCountryResponse response = soapConnector.callWebService("http://localhost:8080/ws", request);*/

        MyString string = new MyString();
        string.setMyString("test");

        return string;
    }

    @GetMapping(value = "/getstringxml", produces = "application/xml")
    @ResponseBody
    public MyString getMyStringXml() {

        MyString string = new MyString();
        string.setMyString("test");

        return string;
    }
}
