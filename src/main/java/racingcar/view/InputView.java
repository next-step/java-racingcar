package racingcar.view;

import racingcar.domain.InputData;

import java.util.Scanner;

public class InputView {

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static InputData getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(CAR_COUNT_MESSAGE);
        int carCount = scanner.nextInt();

        System.out.println(TRY_COUNT_MESSAGE);
        int tryCount = scanner.nextInt();

        return new InputData(carCount, tryCount);
    }
}
