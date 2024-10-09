package racingcar.ui;

import racingcar.domain.UserInputData;

import java.util.Scanner;

public class InputView {

    public static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    public static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public UserInputData getUserInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println(CAR_COUNT_MESSAGE);
        int carCount = sc.nextInt();

        System.out.println(TRY_COUNT_MESSAGE);
        int tryCount = sc.nextInt();

        return new UserInputData(carCount, tryCount);
    }
}
