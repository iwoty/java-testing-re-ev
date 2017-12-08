package pl.iwotyszkowski;

import java.util.List;

public class DiscountCalculator {

    private Customer customer;

    public DiscountCalculator() {
        this.customer = customer;
    }

    public Double calculateDiscount() {
        Double discount = 0.0;

        if (checkIfFemale(this.customer)){
            discount += 5;
        }

        if (checkIfOver60(this.customer)){
            discount += 2;
        }

        if (checkIfOver10Sales(this.customer)){
            discount += 1;
        }

        if (checkIfOver20Sales(this.customer)){
            discount += 1;
        }

        if (checkIfSalesBiggerThan1000(this.customer)){
            discount += 1.5;
        }

        return discount;
    }

    public boolean checkIfFemale(Customer customer) {
        return customer.getGender().equals("Female");
    }

    public boolean checkIfOver60(Customer customer) {
        return customer.getAge() > 60;
    }

    public boolean checkIfOver10Sales(Customer customer) {
        return customer.getSales().size() > 10;
    }

    public boolean checkIfOver20Sales(Customer customer) {
        return customer.getSales().size() > 20;
    }

    public boolean checkIfSalesBiggerThan1000(Customer customer){
        List<Sale> customersSales = customer.getSales();
        int salesSum = 0;

        for (Sale sale: customersSales){
            salesSum += sale.getNetValue().intValue();
        }

        return salesSum > 1000;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}