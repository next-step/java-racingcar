package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    String [] inputs;

    public double add(double a, double b) {
        return a + b;
    }

    public double substract(double a, double b) {
        return  a - b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return  a / b;
    }

    public void getUserInput() {
        System.out.println("계산식을 입력해주세요.");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try {
            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 계산식을 입력해주세요.");
        }
        inputs = input.split(" ");

    }

}
