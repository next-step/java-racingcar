package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER_FOR_INPUT = ",";
    private static final String QUESTION_FOR_CAR = "자동차 이름을 입력하세요, (단, 자동차 이름은 쉼표(,)로 구분해야 합니다.)";
    private static final String QUESTION_FOR_TRY = "몇 회를 시도하실 건가요?";
    private static Scanner scanner = new Scanner(System.in);

    private List<String> carNames;
    private int carCount;
    private int tryCount;
    private Cars cars;

    public InputView(String carNames, String tryCounts) {
        insertCarNames(carNames);
        insertTryCount(tryCounts);
        cars = new Cars(createCars());
    }

    public static String getCarNamesFromUser() {
        System.out.println(QUESTION_FOR_CAR);
        return scanner.nextLine();
    }

    public static String getTryCountsFromUser() {
        System.out.println(QUESTION_FOR_TRY);
        return scanner.nextLine();
    }

    public List<Car> createCars() {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void insertCarNames(String carNameString) {
        validateNullOrEmpty(carNameString);
        this.carNames = splitCarNames(carNameString);
        this.carCount = carNames.size();
    }

    private void insertTryCount(String stringTryCount) {
        validateNullOrEmpty(stringTryCount);
        this.tryCount = validateNumberType(stringTryCount);
    }

    private List<String> splitCarNames(String stringInput) {
        return Arrays.asList(stringInput.split(DELIMITER_FOR_INPUT));
    }

    private int validateNumberType(String stringInput) {
        int intInput = validateNumber(stringInput);
        validateNegative(intInput);
        return intInput;
    }

    private void validateNullOrEmpty(String stringInput) {
        validateNull(stringInput);
        validateEmpty(stringInput);
    }

    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null은 입력할 수 없습니다.");
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("공백 문자열은 입력할 수 없습니다.");
        }
    }

    private int validateNumber(String input) {
        int intInput;
        try {
            intInput = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return validateNegative(intInput);
    }

    private int validateNegative(int intInput) {
        if (intInput <= 0) {
            throw new IllegalArgumentException("0 이하의 숫자는 입력할 수 없습니다.");
        }
        return intInput;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public Cars getCars() {
        return cars;
    }
}