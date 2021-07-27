import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("수식을 입력하세요");
        Scanner scanner = new Scanner(System.in);
        String mathExpression = scanner.nextLine();

        Calculator calculator = new Calculator();
        try {
            String result = calculator.execute(mathExpression);
            System.out.println("result : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 수식");
        }
    }
}
