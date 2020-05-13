package study.step2;

public class ExcuteClass {
    private static String expression;

    public static void main(String[] args) {
        expression = "2 + 3 * 4 / 2";
        StringCalculator stringCalculator = new StringCalculator();
        String result = stringCalculator.cal(expression);
        System.out.println(result);
    }
}
