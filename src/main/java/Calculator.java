
import java.util.Scanner;

public class Calculator {
    public double calRes =0;
    private final String regExp = "^[0-9]+";
private static final Scanner SCANNER = new Scanner(System.in);
    public Double getcalRes() {
        return this.calRes;
    }
    public Calculator() {
        String input = getInput();
        String[] inputArray = split(input);
        double calRes=calculate(inputArray);
    }
    public Calculator(String input) {
        String[] inputArray = split(input);
        double calRes=calculate(inputArray);
    }
    public double Calculator(String input) {
        String[] inputArray = split(input);
        double calcuRes=calculate(inputArray);
        return calcuRes;
    }
    private double calculate(String[] inputArray) {
        double tempResult= Double.parseDouble(inputArray[0]);
        for (int i = 1; i < inputArray.length; i++) {
            if (!inputArray[i].matches(regExp)) {
                tempResult = operateArithmetic(tempResult,inputArray[i],Integer.parseInt(inputArray[i + 1]));
            }
        }
        Double result=tempResult;
        return result;
    }
    public double operateArithmetic(double res, String operator, double temp){
        switch (operator) {
            case "+":
                return plus(res,temp);
            case "-":
                return minus(res,temp);
            case "*":
                return multiply(res,temp);
            case "/":
                return divide(res,temp);
            default:
                throw new IllegalArgumentException("");
        }
    }


    double plus(double res, double temp){
        return res+temp;
    }
    double minus(double res, double temp){
        return res+temp;
    }
    double multiply(double res, double temp){
        return res+temp;
    }
    double divide(double res, double temp){
        return res+temp;
    }

    public String[] split(String input) {
        String[] arr = input.split(" ");
        return arr;
    }

    public static String getInput() {
        System.out.println("-----------");
        return SCANNER.nextLine();
    }
}
