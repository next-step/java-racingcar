package calculator;

public class Application {

    public static void main(String[] args) {
        String input = "2 + 3 * 4 / 2";
        Utils.checkEmpty(input);
        String[] split = input.split(" ");

        long left = Utils.stringToLong(split[0]);
        for (int i = 0; i < split.length - 1; i += 2) {
            String operator = split[i + 1];
            long right = Utils.stringToLong(split[i + 2]);
            left = Calculator.calculate(left, right, operator);
            System.out.println(left);
        }

        System.out.println(input + " = " + left);
    }

}
