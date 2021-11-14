package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_INPUT_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NUMBER_INPUT_MSG = "시도할 회수는 몇 회 인가요?";
    private static final String COMMA = ",";
    private static final int CAR_NAME_REFERENCE_VALUE = 5;
    private static final String CAR_NAME_LIMIT_MSG = "자동차 이름은 5자를 초과할 수 없습니다.";

    private List<String> carNames;
    private int tryCount;

    public void startRacingGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(CAR_NAME_INPUT_MSG);
        this.carNames = splitAndMakeCarNames(scanner);

        System.out.println(TRY_NUMBER_INPUT_MSG);
        this.tryCount = scanner.nextInt();
    }

    private List<String> splitAndMakeCarNames(Scanner scanner) {
        String[] carNameArray = scanner.next().split(COMMA);
        List<String> carNames = Arrays.asList(carNameArray);
        for (String carName : carNames) {
            limitCarNameLength(carName);
        }
        return carNames;
    }

    private void limitCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_REFERENCE_VALUE) {
            throw new IndexOutOfBoundsException(CAR_NAME_LIMIT_MSG);
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
       return tryCount;
    }
}
