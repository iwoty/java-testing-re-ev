package pl.iwotyszkowski;

import java.math.BigDecimal;

public class Sale {

    private int id;
    private String productName;
    private BigDecimal netValue;
    private int taxRate;

    public Sale(int id, String productName, BigDecimal netValue, int taxRate) {

        if (productName.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.productName = productName;
        }

        if (netValue.signum() == -1) {
            throw new IllegalArgumentException();
        } else {
            this.netValue = netValue.setScale(2, BigDecimal.ROUND_DOWN);
        }

        if (taxRate > 100 || taxRate < 0) {
            throw new IllegalArgumentException();
        } else {
            this.taxRate = taxRate;
        }

        this.id = id;
    }

    public BigDecimal getGrossValue() {
        return netValue.add(netValue.multiply(BigDecimal.valueOf((double)taxRate/100))).setScale(2, BigDecimal.ROUND_DOWN);
    }

    public BigDecimal getNetValue() {
        return netValue;
    }
}