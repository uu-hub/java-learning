package io.zbc.learning.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Testing {
    public static void main(String[] args) {
        BigDecimal strDiscountValue = new BigDecimal("1.00445000").subtract(new BigDecimal(1.0000000)).setScale(4, BigDecimal.ROUND_HALF_UP);
        String TotalDiscountValue = strDiscountValue.toPlainString();
        System.out.println(TotalDiscountValue);
    }

    public static boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }

}
