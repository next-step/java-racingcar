import java.util.Scanner;

public class StringCalculatorView {
    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void outputResult(int result) {
        System.out.println(result);
    }
}
