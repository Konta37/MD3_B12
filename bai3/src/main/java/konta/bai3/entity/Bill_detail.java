package konta.bai3.entity;

public class Bill_detail {
    private int bill_detail_id;
    private int bill_id;
    private int product_id;
    private int quantity;
    private float price;

    public Bill_detail() {
    }

    public Bill_detail(int bill_detail_id, int bill_id, int product_id, int quantity, float price) {
        this.bill_detail_id = bill_detail_id;
        this.bill_id = bill_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public int getBill_detail_id() {
        return bill_detail_id;
    }

    public void setBill_detail_id(int bill_detail_id) {
        this.bill_detail_id = bill_detail_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
