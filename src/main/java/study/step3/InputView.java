package study.step3;

import java.util.Scanner;

public class InputView {

    public RacingInput getRacingInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int cars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int trys = scanner.nextInt();

        RacingInput racingInput = new RacingInput(cars, trys);

        scanner.close();

        return racingInput;
    }

}
