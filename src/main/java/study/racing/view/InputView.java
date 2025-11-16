package study.racing.view;

import study.racing.domain.CarName;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CAR_NAMES = "경주할 자동자 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회 인가요?";
    private static final String ERROR_BLANK_INPUT = "입력 값으로 공백은 허용되지 않습니다.";
    private static final String ERROR_INVALID_NUMBER = "숫자만 입력 가능합니다. 다시 입력해주세요.";
    private static final String ERROR_NOT_POSITIVE = "입력 값은 0보다 커야 합니다. 다시 입력해주세요.";

    public static List<CarName> getCarNames(){
        System.out.println(INPUT_CAR_NAMES);
        List<String> names = namesInput();
        validateNames(names);
        return names.stream().map(CarName::new).toList();
    }

    public static int getRoundCount(){
        System.out.println(INPUT_ATTEMPT_COUNT);
        int roundCount =  numberInput();
        validateNumber(roundCount);
        return roundCount;
    }

    private static void validateNames(List<String> names) {
        for (String name : names) {
            validateString(name);
            validateNameLength(name);
        }
    }

    private static void validateString(String names) {
        if (isBlank(names)) {
            throw new RuntimeException("레이스 참가자 이름은 필수입니다.");
        }
    }

    private static boolean isBlank(String names) {
        return names == null || names.isBlank();
    }

    private static void validateNameLength(String name) {
        if (isNameLength(name)) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static boolean isNameLength(String name) {
        return name.length() > 5;
    }

    private static void validateNumber(int numberOfAttempts) {
        if (numberOfAttempts < 1) {
            throw new RuntimeException("레이스 횟수는 1회 이상이어야 합니다.");
        }
    }

    private static List<String> namesInput() {
        while (true) {
            String names = scanner.next();
            if (!names.isBlank()) {
                return Arrays.asList(names.split(","));
            }
            System.out.println(ERROR_BLANK_INPUT);
        }
    }

    public static int numberInput() {
        while (true) {
            try {
                int number = scanner.nextInt();
                checkNumber(number);
                return number;
            } catch (InputMismatchException e) {
                System.out.println(ERROR_INVALID_NUMBER);
                scanner.nextLine();
            } catch (RuntimeException e) {
                System.out.println(ERROR_NOT_POSITIVE);
            }
        }
    }

    private static void checkNumber(int number) {
        if (number < 1) {
            throw new RuntimeException();
        }
    }
}
