package calculator;

public class CalculMain {

    public static void main(String[] args){

        Calculator calculator = new Calculator("2 * 3 + 4 / 2");

        System.out.println(calculator.calculateUserInput());

    }
}
