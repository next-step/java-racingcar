package Calculator;

public class StringCalculateMain {

    public static StringCalculatorExecutor stringCalculaterExecutor = new StringCalculatorExecutor();

    public static void main(String[] args) {

        String [] numberAndOperator = "2 + 3 * 4 / 2".split(" ");

        int result = 0;

        result = stringCalculaterExecutor.stringCalculator(numberAndOperator);

        System.out.println("결과값:"+result);
    }

}
