package step3;

import java.util.Scanner;

public class RacingInput {
    private static final String DELIMETER = ",";

    public int inputForInt(String inputMsg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(inputMsg);
        int scanNumber = scanner.nextInt();
        return scanNumber;
    }

    public String[] inputForString(String inputMsg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(inputMsg);
        String scanString = scanner.nextLine();

        return scanString.split(DELIMETER);
    }
}

