package step3and4.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final int MINIMUM_NUMBER = 0;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static InputRequest createInputRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNamesSplit = createCarNames();
        System.out.println("시도할 횟수는 몇 회 인가여?");
        int tryNumber = createIntNumber(SCANNER);
        return new InputRequest(carNamesSplit, tryNumber);
    }

    private static String[] createCarNames() {
        String carNames = SCANNER.next();
        return carNames.split(",");
    }

    private static int createIntNumber(Scanner scanner) {
        try {
            int carNumber = scanner.nextInt();
            if (carNumber < MINIMUM_NUMBER) {
                throw new InputMismatchException();
            }
            return carNumber;
        } catch (InputMismatchException exception) {
            throw new InputMismatchException("양수의 숫자만 입력해주세요");
        }
    }
}
