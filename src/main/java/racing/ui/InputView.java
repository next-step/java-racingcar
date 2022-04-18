package racing.ui;

import racing.domain.CarValidator;
import racing.exception.CarNameLengthException;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(",");

        try {
            checkCarNamesLength(carNames);
        } catch (CarNameLengthException e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }

        return carNames;
    }

    private static void checkCarNamesLength(String[] carNames) {
        for (String carName : carNames) {
            CarValidator.checkCarNamesLength(carName);
        }
    }

    public static int inputNumberOfRounds() {
        System.out.println("시도할 회수는 몇 회인가요?");

        return scanner.nextInt();
    }
}
