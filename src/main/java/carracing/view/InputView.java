package carracing.view;

import carracing.model.NameOfCar;
import carracing.model.NumberOfAttempts;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static carracing.RacingGameSetupValidator.isNonBlank;

public class InputView {
    private static final String NAME_OF_CARS_INPUT_GUID_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_OF_ATTEMPTS_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String WRONG_INPUT_MESSAGE = "잘못된 입력입니다";
    private static final String COMMA_DELIMITER = ",";

    private InputView() {
    }

    public static List<NameOfCar> enteredNameOfCars() {
        System.out.println(NAME_OF_CARS_INPUT_GUID_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();

        if (!isNonBlank(names)) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }

        return Arrays.stream(names.split(COMMA_DELIMITER))
                .map(NameOfCar::newName)
                .collect(Collectors.toList());
    }

    public static NumberOfAttempts enteredNumberOfAttempts() {
        System.out.println(NUMBER_OF_ATTEMPTS_INPUT_GUIDE_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        return NumberOfAttempts.newNumber(scanner.nextLine());
    }
}
