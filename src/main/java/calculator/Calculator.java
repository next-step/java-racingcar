package calculator;

import java.util.*;

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

    public void start() {
        getUserInput();
        takeArguments();
        // 1 + 2 - 1
        // 1 + 2  = 3
        // 3 - 1 = 2
        // while (!q.isEmpty()) {
        // 계산  }
    }

    private void takeArguments() {

        for (int i=0; i<inputs.length; i++) {
            calculate(i);
        }

    }

    private void calculate(int index) {

    }

//    private boolean isNumber(String input) {
//        char ch = input.charAt(0);
//        if (Character.isDigit(ch)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

}
