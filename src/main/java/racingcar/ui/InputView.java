package racingcar.ui;

import racingcar.dto.RacingGameOption;

import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public static RacingGameOption inputRacingGameOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String racingCarNames = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfTimes = scanner.nextInt();

        return new RacingGameOption(racingCarNames, numberOfTimes);
    }
}
