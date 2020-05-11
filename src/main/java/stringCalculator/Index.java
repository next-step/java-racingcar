package stringCalculator;

public class Index {
    public static void main(String[] args) {
        String input =  "2 + 3 * 4 / 2";

        Calculator calculator = new Calculator();
        int result = calculator.main(input);

        System.out.println(result);
    }
}
