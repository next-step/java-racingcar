package racingcar;

import java.util.Scanner;

public class InputView {

    public static void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        RacingCar.getInstance().initializeCar(carNum);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int match = scanner.nextInt();
        RacingCar.getInstance().setMatch(match);
    }
}
