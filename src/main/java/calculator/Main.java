package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userinput = scanner.nextLine();

        new StringCalculator().splitUserInput(userinput);
    }
}
