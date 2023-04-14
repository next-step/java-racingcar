package racingcar;

import java.util.Scanner;

public class InputView {

    public RacingCar init() {
        Scanner scanner = new Scanner(System.in);

        Integer carCount = getCarCount(scanner);
        Integer trialCount = getTrialCount(scanner);

        System.out.println("carCount = " + carCount);
        System.out.println("trialCount = " + trialCount);

        return new RacingCar(carCount, trialCount);
    }

    private Integer getCarCount(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    private static Integer getTrialCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

}
