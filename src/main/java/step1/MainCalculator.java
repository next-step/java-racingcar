package step1;

import java.util.Scanner;

public class MainCalculator {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.excuteCalculation(inputString));
    }

}
