package pl.iwotyszkowski;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Customer {

    private int id;
    private String name;
    private String surname;
    private int birthyear;
    private String gender;
    private List<Sale> sales;

    public Customer(int id,
                    String name,
                    String surname,
                    int birthyear,
                    String gender) throws IllegalArgumentException {

        if (name.equals("") || surname.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.surname = surname;
        }

        if (birthyear < 1900 || birthyear > 2017) {
            throw new IllegalArgumentException();
        } else {
            this.birthyear = birthyear;

        }
        if (!gender.equals("Male") && !gender.equals("Female")) {
            throw new IllegalArgumentException();
        } else {
            this.gender = gender;
        }

        this.id = id;
        this.sales = new ArrayList<>();
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - birthyear;
    }

    public String getGender() {
        return gender;
    }

    public List<Sale> getSales() {
        return sales;
    }
}