
import java.util.Scanner;

public class Calculator {
    private String[] arr;
    private Double res = 0.0;
    private int temp = 0;
    private final String regExp = "^[0-9]+";
    private static final Scanner SCANNER = new Scanner(System.in);
    public Double getRes() {
        return this.res;
    }
    private void resetTemp() {
        this.temp = 0;
    }


    private void parse(int i) {
        if (!arr[i].matches(regExp)) {
            temp = Integer.parseInt(arr[i + 1]);
            switch (arr[i]) {
                case "+":
                    this.res += temp;
                    resetTemp();
                    break;
                case "-":
                    this.res -= temp;
                    resetTemp();
                    break;
                case "*":
                    this.res *= temp;
                    resetTemp();
                    break;
                case "/":
                    this.res /= temp;
                    resetTemp();
                    break;
                default:
                    throw new IllegalArgumentException("");
            }
        }
    }

    public Calculator(String input) {
        this.arr = split(input);
        calculate();
    }
    private int calculate() {
        res = Double.parseDouble(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            parse(i);
        }
        System.out.println(res);
        return 0;
    }

    private String[] split(String input) {
        String[] arr = input.split(" ");
        return arr;
    }


    public static void main(String[] args) {
        String input = getInput();
        new Calculator(input);
    }

    public static String getInput() {
        System.out.println("-----------");
        return SCANNER.nextLine();
    }
}
