import calculator.StringAddCalculator;
import java.util.Scanner;

public class StringAddCalculatorApplication {

    public static final Scanner CONSOLE = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("계산할 문자열을 입력하세요. : ");
        String inputStr = CONSOLE.nextLine();
        try {
            System.out.println("계산 값은 "+ StringAddCalculator.splitAndSum(inputStr) + "입니다.");
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }

        CONSOLE.close();
    }
}
