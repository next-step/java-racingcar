package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_FOR_TRY_COUNT = "시도할 횟수는 몇 회 인가요?";
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static List<Car> inputCarNames() {
        System.out.println(INPUT_CAR_NAME);
        String carNames = scanner.nextLine();
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames.split(CAR_NAME_SEPARATOR)) {
            checkCarNameLength(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static void checkCarNameLength(String carName) {
        if (MAX_CAR_NAME_LENGTH < carName.length()) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static int inputTryCount() {
        System.out.println(QUESTION_FOR_TRY_COUNT);
        int tryCount = scanner.nextInt();
        if (tryCount <= 0) {
            throw new RuntimeException("1 이상의 숫자를 입력 받아야 합니다.");
        }
        return tryCount;
    }
}
