package vttp2022.day24.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.day24.model.Item;
import vttp2022.day24.model.PurchaseOrder;

import static vttp2022.day24.repositories.Queries.*;

@Repository
public class PORepo {

    @Autowired
    private JdbcTemplate jTemplate;

    public Integer submitPO(PurchaseOrder po){
        int firstupdate = jTemplate.update(
            SQL_CREATE_PURCHASE_ORDER,
            po.getOrderid(),
            po.getName(),
            po.getDate());
        int secondupdate = 0;
        for (int k = 0; k < po.getItems().size(); k ++){
            Item i = po.getItems().get(k);
            secondupdate =+ jTemplate.update(
            SQL_CREATE_LINE_ITEM,
            i.getQuantity(),
            i.getSku());
        }
        System.out.println(">>>>>>>line item succesfully added: " + (secondupdate > 0));
        System.out.println(">>>>>>>PO succesfully added: " + (firstupdate > 0));
        return firstupdate + secondupdate;
    }

}
