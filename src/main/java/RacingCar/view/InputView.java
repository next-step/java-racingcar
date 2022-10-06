package RacingCar.view;

import RacingCar.domain.Validate;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scan();
    }

    public int round() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanUnsignedInt();
    }

    public static int scanUnsignedInt() {
        String input = SCANNER.nextLine();

        Validate.numberValidate(input);

        int inputNumber = Integer.parseInt(input);

        Validate.negativeValidate(inputNumber);

        return inputNumber;
    }

    public static String scan() {
        return SCANNER.nextLine();
    }
}
