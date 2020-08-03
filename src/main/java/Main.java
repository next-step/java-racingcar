import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        System.out.println(StringCalculator.calculateResult(input));
    }
}
