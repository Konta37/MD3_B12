package konta.bai3.entity;

import java.util.Date;

public class Bill {
    private int bill_id;
    private String bill_code;
    private Boolean bill_type;
    private Integer acc_id_created;
    private Date created;
    private Date auth_date;

    public Bill() {
    }

    public Bill(int bill_id, String bill_code, Boolean bill_type, Integer acc_id_created, Date created, Date auth_date) {
        this.bill_id = bill_id;
        this.bill_code = bill_code;
        this.bill_type = bill_type;
        this.acc_id_created = acc_id_created;
        this.created = created;
        this.auth_date = auth_date;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getBill_code() {
        return bill_code;
    }

    public void setBill_code(String bill_code) {
        this.bill_code = bill_code;
    }

    public Boolean getBill_type() {
        return bill_type;
    }

    public void setBill_type(Boolean bill_type) {
        this.bill_type = bill_type;
    }

    public Integer getAcc_id_created() {
        return acc_id_created;
    }

    public void setAcc_id_created(Integer acc_id_created) {
        this.acc_id_created = acc_id_created;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getAuth_date() {
        return auth_date;
    }

    public void setAuth_date(Date auth_date) {
        this.auth_date = auth_date;
    }
}
