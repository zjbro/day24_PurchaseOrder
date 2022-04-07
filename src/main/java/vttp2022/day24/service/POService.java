package vttp2022.day24.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import vttp2022.day24.model.Item;
import vttp2022.day24.model.PurchaseOrder;

@Service
public class POService {
    
    public PurchaseOrder generatePO(MultiValueMap<String, String> form){
        List<Item> items = new LinkedList<>();
        if(!form.getFirst("sku1").equals(null)){
            Item i = new Item(form.getFirst("sku1"), Integer.parseInt(form.getFirst("qty1")));
            items.add(i);
        }

        if(!form.getFirst("sku2").equals(null)){
            Item i = new Item(form.getFirst("sku2"), Integer.parseInt(form.getFirst("qty2")));
            items.add(i);
        }

        if(!form.getFirst("sku3").equals(null)){
            Item i = new Item(form.getFirst("sku3"), Integer.parseInt(form.getFirst("qty3")));
            items.add(i);
        }

        if(!form.getFirst("sku4").equals(null)){
            Item i = new Item(form.getFirst("sku4"), Integer.parseInt(form.getFirst("qty4")));
            items.add(i);
        }
        System.out.println(">>>>>>>>>qty value" + items.get(0).getQuantity());
        PurchaseOrder po = new PurchaseOrder(form.getFirst("name"), form.getFirst("date"), items);
        return po;
    }
}
