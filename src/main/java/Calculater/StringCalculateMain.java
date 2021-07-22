package Calculater;

public class StringCalculateMain {

    public static StringCalculaterExecuteClass stringCalculaterExecuteClass = new StringCalculaterExecuteClass();

    public static void main(String[] args) {

        String [] numberAndOperator = "2 + 3 * 4 / 2".split(" ");

        int result = 0;

        result = stringCalculaterExecuteClass.stringCalculator(numberAndOperator);

        System.out.println("결과값:"+result);
    }

}
