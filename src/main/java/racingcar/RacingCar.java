package racingcar;

import java.util.Scanner;

public class RacingCar {
    public static void inputView() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("자동차 대수는 몇 대 인가요?");
        String carCount = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        String trialCount = scanner.nextLine();

        System.out.println("carCount = " + carCount);
        System.out.println("trialCount = " + trialCount);
    }
}
