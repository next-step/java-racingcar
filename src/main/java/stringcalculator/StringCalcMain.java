package stringcalculator;

import java.util.Scanner;

import org.junit.platform.commons.util.StringUtils;

public class StringCalcMain {

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // String value = sc.next();
        String value = "2 + 3 * 4 / 2";
        if(value == null || value.equals("") ){
            throw new IllegalArgumentException("Input is null or empty, Please check your input");
        }

        StringCalculator strCalc = new StringCalculator();
        strCalc.calculator(value);
    }

}