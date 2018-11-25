package model;

import java.util.Date;

public class Account {
    private String type;
    private String name;
    private int id;

    private Date createDate;

    public Account(String type, String name) {
        this.type = type;
        this.name = name;
        setCreateDate(new Date());
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    private void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


}
