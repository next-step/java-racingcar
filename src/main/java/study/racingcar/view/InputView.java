package study.racingcar.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String CAR_NAME_DELIMITER = ",";

    public static int getTryCount() {
        return getNumber();
    }

    public static List<String> getCarNames() {
        List<String> carNames = convertToList(scanner.next());
        validateCarNameList(carNames);
        return carNames;
    }
    private static void validateCarNameList(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException("올바른 이름 값을 입력하세요.");
        }
    }
    private static List<String> convertToList(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .collect(Collectors.toList());
    }
    private static int getNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}