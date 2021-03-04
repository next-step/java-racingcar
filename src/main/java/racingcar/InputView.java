package racingcar;

import java.util.Scanner;

public class InputView {

    private static RacingCar racingCar = new RacingCar();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int cntCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int cntTry = scanner.nextInt();

        racingCar.startRacing(cntCar, cntTry);
    }
}
