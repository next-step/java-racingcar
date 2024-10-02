package racingcar;

import java.util.Scanner;

public class InputView {

    public static void getUserInput(RacingCar racingCar) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        racingCar.initializeCar(carNum);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int match = scanner.nextInt();
        racingCar.setMatch(match);
    }
}
