package racingcar.view;

import racingcar.domain.InputData;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static InputData getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(CAR_NAMES_MESSAGE);
        String carNames = scanner.next();

        System.out.println(TRY_COUNT_MESSAGE);
        int tryCount = scanner.nextInt();

        return new InputData(carNames, tryCount);
    }
}
