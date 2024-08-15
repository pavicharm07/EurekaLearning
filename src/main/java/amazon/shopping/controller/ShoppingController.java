package amazon.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class ShoppingController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("amazonShopping/{price}")
    public String invokePaymentService(@PathVariable int price){
        String url = "http://PAYMENT-SERVICE/payment-provider/get/"+price;
        return restTemplate.getForObject(url,String.class);
    }
}
