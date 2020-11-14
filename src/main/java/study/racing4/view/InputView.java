package study.racing4.view;

import study.racing4.domain.RacingInput;

import java.util.Scanner;

public class InputView {

    public RacingInput getRacingInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.");
        String rawCarsString = scanner.nextLine();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int rounds = scanner.nextInt();

        RacingInput racingInput = new RacingInput(rawCarsString, rounds);

        scanner.close();

        return racingInput;
    }

}
