package Calculator;

public class StringCalculateMain {

    public static StringCalculationExecutor stringCalculaterExecutor = new StringCalculationExecutor();

    public static void main(String[] args) {

        String [] numberAndOperator = "2 + 3 * 4 / 2".split(" ");

        int result = stringCalculaterExecutor.stringCalculator(numberAndOperator);

        System.out.println("결과값:" + result);
    }

}
