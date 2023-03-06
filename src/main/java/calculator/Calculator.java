package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Calculator {
    int a = Integer.MIN_VALUE;
    int b = Integer.MIN_VALUE;

    String operand = "";

    public int add(int a, int b) {
        return a+b;
    }
    public int substract(int a, int b) {
        return a-b;
    }
    public int multiply(int a, int b) {
        return a*b;
    }
    public int divide(int a, int b) {
        return a/b;
    }

    public static void main(String[] args) {
        String input = "2 + 3 / 1";
        String[] numbers = input.split("[^0-9]");
        String[] operands = input.split("[0-9]+");
        for(String s : numbers) System.out.print(s);
        System.out.println("");
        for(String s : operands) System.out.print(s);
    }

    public int calulator(String input) {
        inputValidCheck(input);

        List<String> inputString = new ArrayList<>();
        inputString.addAll(List.of(input.split(" ")));
        a = Integer.parseInt(inputString.get(0));
        inputString.remove(0);

        while(!inputString.isEmpty()) {
            operand = operandValidCheck(inputString.get(0));
            inputString.remove(0);
            b = Integer.parseInt(inputString.get(0));
            System.out.print(a + " " + operand + " " + b + " = ");
            a = excuteCalulator(a,b,operand);
            System.out.println(a);
            inputString.remove(0);
        }
        System.out.println(a);
        return a;
    }

    @Contract("_ -> param1")
    private @NotNull String operandValidCheck(String operand) {
        if(!(operand.equals("+") || operand.equals("-") || operand.equals("*") || operand.equals("/"))) {
            throw new IllegalArgumentException("사칙연산 기호가 아닌 기호가 포함되어있습니다. ("+operand+")");
        }
        return operand;
    }

    private int excuteCalulator(int a, int b, String operand) {
        if(operand.equals("+"))
            return add(a, b);
        if(operand.equals("-"))
            return substract(a, b);
        if(operand.equals("*"))
            return multiply(a, b);
        if(operand.equals("/"))
            return divide(a, b);
        return -9;
    }

    private void inputValidCheck(String input) {
        if(input.isBlank() || input.isEmpty() || input == null) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
        }
    }

}