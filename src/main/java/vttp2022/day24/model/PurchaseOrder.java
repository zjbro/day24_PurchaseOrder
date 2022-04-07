package vttp2022.day24.model;

import java.util.List;
import java.util.UUID;

public class PurchaseOrder {
    private String orderid;
    private String name;
    private String date;
    private List<Item> items;

    
    
    public PurchaseOrder(String name, String date, List<Item> items) {
        this.name = name;
        this.date = date;
        this.items = items;
        this.orderid = setUniqueId();
    }


    public String setUniqueId(){
        String uniqueId = UUID.randomUUID().toString();
        return uniqueId.substring(0,8);
    }

    public String getOrderid() {
        return orderid;
    }
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    
    
}
