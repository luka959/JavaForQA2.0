package com.company.sweets;

public class Candy extends Sweet {
    private final int caloricity;

    public Candy() {
        super(3.3, 4.3, SweetType.CANDY);
        this.caloricity = 100;
    }

    public int getCaloricity() {
        return caloricity;
    }
}
