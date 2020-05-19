package step3;

import java.util.Scanner;

public class RacingInput {
    public int InputInfo(String inputMsg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(inputMsg);
        int scanNumber = scanner.nextInt();
        return scanNumber;
    }
}

