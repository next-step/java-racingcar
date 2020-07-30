package unittest;

import java.util.Scanner;

public class CalculatorImpl implements Calculator{

    public static void main(String[] args) {

        Calculator cal = new CalculatorImpl();
        String inputText = cal.readInput();
        String[] inputArr = cal.splitInput(inputText);





    }


    @Override
    public String readInput() {
        Scanner scan = new Scanner(System.in);
        String inputText = scan.nextLine();

        return inputText;
    }

    @Override
    public String[] splitInput(String input) throws IllegalArgumentException{
        if(null == input || input.length() == 0) {
            throw new IllegalArgumentException();
        }
        return input.split(" ");
    }

    @Override
    public void validate(String[] inputArr) throws IllegalArgumentException {

    }

    @Override
    public void calutate(String[] inputArr) {

    }

    @Override
    public int add(int a, int b) {

        return a + b;
    }

    @Override
    public int substract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }
}
