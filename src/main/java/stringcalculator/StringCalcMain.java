package stringcalculator;

import java.util.Scanner;

public class StringCalcMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String value = sc.next();
        StringCalculator strCalc = new StringCalculator();
        strCalc.calculator(value);
    }
}