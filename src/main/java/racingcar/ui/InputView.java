package racingcar.ui;

import racingcar.domain.UserInputData;

import java.util.Scanner;

public class InputView {

    public static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public UserInputData getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(CAR_NAME_MESSAGE);
        String carNames = scanner.nextLine();

        System.out.println(TRY_COUNT_MESSAGE);
        int tryCount = scanner.nextInt();

        return new UserInputData(carNames, tryCount);
    }
}
