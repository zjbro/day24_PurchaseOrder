package vttp2022.day24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.day24.model.PurchaseOrder;
import vttp2022.day24.repositories.PORepo;
import vttp2022.day24.service.POService;

@Controller
@RequestMapping
public class POController {
    
    @Autowired
    private PORepo poRepo;

    @Autowired
    private POService poService;

    @PostMapping("/po")
    public String receivePurchaseOrder (
        @RequestBody MultiValueMap<String, String> form,
        Model model){
            PurchaseOrder po = poService.generatePO(form);
            Integer status = poRepo.submitPO(po);
            if (status > 1){ 
                System.out.println("Purchase order successfully added");
                return "order";
            }
       return "error";
    }
}
