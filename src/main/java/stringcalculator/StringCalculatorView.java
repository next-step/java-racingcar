package stringcalculator;

import java.util.Scanner;

public class StringCalculatorView {
    private Scanner scanner = new Scanner(System.in);

    public String inputString() {
        return scanner.nextLine();
    }

    public void outputResult(int result) {
        System.out.println(result);
    }
}
