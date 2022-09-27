package RacingCar;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public int carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanInt();
    }

    public int round() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanInt();
    }

    public static int scanInt() {
        String input = SCANNER.nextLine();

        Validate.numberValidate(input);

        int inputNumber = Integer.parseInt(input);

        Validate.negativeValidate(inputNumber);

        return inputNumber;
    }
}
