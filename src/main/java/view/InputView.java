package view;

import game.CarName;
import util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String NAME_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int readPositiveInteger(String question) {
        System.out.println(question);
        String value = SCANNER.nextLine();
        try {
            return toInteger(value);
        } catch (NumberFormatException e) {
            System.out.println("0보다 큰 양의 정수를 입력해주세요. 입력값=" + value);
            return readPositiveInteger(question);
        }
    }

    private static int toInteger(String value) {
        int result = Integer.parseInt(value);
        if (result <= 0) {
            throw new NumberFormatException("0보다 큰 양의 정수가 아닙니다. 입력값=" + value);
        }
        return result;
    }

    public static List<CarName> readCarNames(String question) {
        System.out.println(question);
        String carNames = SCANNER.nextLine();
        try {
            return parseCSVCarNames(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCarNames(question);
        }
    }

    private static List<CarName> parseCSVCarNames(String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        }
        if (!carNames.contains(NAME_DELIMITER)) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분되어야 합니다.");
        }
        String[] names = carNames.split(NAME_DELIMITER);
        if (names.length < 2) {
            throw new IllegalArgumentException("자동차 이름은 최소 2개 이상이어야 합니다.");
        }
        return convertToCarNames(names);
    }

    private static List<CarName> convertToCarNames(String[] names) {
        return Arrays.stream(names)
                .map(CarName::new)
                .collect(Collectors.toList());
    }
}
