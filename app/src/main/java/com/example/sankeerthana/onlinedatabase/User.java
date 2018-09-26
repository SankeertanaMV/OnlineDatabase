package com.example.sankeerthana.onlinedatabase;

public class User {

    private String year,month,name,mailId,bill_ep1,bill_ep2,bill_ep3,bill_flat,usage_ep1,usage_ep2,usage_ep3,usage_flat;

    public User(String year,String month,String name,String mailId,String bill_ep1,String bill_ep2,String bill_ep3,String bill_flat,
                String usage_ep1,String usage_ep2,String usage_ep3,String usage_flat){

        this.setYear(year);
        this.setMonth(month);
        this.setName(name);
        this.setMailId(mailId);
        this.setBill_ep1(bill_ep1);
        this.setBill_ep2(bill_ep2);
        this.setBill_ep3(bill_ep3);
        this.setBill_flat(bill_flat);
        this.setUsage_ep1(usage_ep1);
        this.setUsage_ep2(usage_ep2);
        this.setUsage_ep3(usage_ep3);
        this.setUsage_flat(usage_flat);

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getBill_ep1() {
        return bill_ep1;
    }

    public void setBill_ep1(String bill_ep1) {
        this.bill_ep1 = bill_ep1;
    }

    public String getBill_ep2() {
        return bill_ep2;
    }

    public void setBill_ep2(String bill_ep2) {
        this.bill_ep2 = bill_ep2;
    }

    public String getBill_ep3() {
        return bill_ep3;
    }

    public void setBill_ep3(String bill_ep3) {
        this.bill_ep3 = bill_ep3;
    }

    public String getBill_flat() {
        return bill_flat;
    }

    public void setBill_flat(String bill_flat) {
        this.bill_flat = bill_flat;
    }

    public String getUsage_ep1() {
        return usage_ep1;
    }

    public void setUsage_ep1(String usage_ep1) {
        this.usage_ep1 = usage_ep1;
    }

    public String getUsage_ep2() {
        return usage_ep2;
    }

    public void setUsage_ep2(String usage_ep2) {
        this.usage_ep2 = usage_ep2;
    }

    public String getUsage_ep3() {
        return usage_ep3;
    }

    public void setUsage_ep3(String usage_ep3) {
        this.usage_ep3 = usage_ep3;
    }

    public String getUsage_flat() {
        return usage_flat;
    }

    public void setUsage_flat(String usage_flat) {
        this.usage_flat = usage_flat;
    }
}
