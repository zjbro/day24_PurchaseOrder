package vttp2022.day24.repositories;


public interface Queries {
    public static final String SQL_CREATE_PURCHASE_ORDER = "insert into purchase_order (order_id, name, order_date) values(?, ?, ?)";
    public static final String SQL_CREATE_LINE_ITEM = "insert into line_item (quantity, prod_id) values(?, ?)";
}
