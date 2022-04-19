package racing.ui;

import racing.domain.CarNameValidator;
import racing.exception.CarNameLengthException;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_NUMBER_OF_ROUND_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String DELIMETER = ",";

    private InputView() {
    }

    public static String[] inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String[] carNames = SCANNER.nextLine().split(DELIMETER);

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
            CarNameValidator.checkCarNamesLength(carName);
        }
    }

    public static int inputNumberOfRounds() {
        System.out.println(INPUT_NUMBER_OF_ROUND_MESSAGE);

        return SCANNER.nextInt();
    }
}
