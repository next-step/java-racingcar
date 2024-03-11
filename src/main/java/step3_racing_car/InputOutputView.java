package step3_racing_car;

import java.util.Scanner;

public class InputOutputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static void printGameResult(int participantCarCount, RacingCars racingCars) {
        System.out.println("실행결과");
        for (int i = 0; i < participantCarCount; i++) {
            int position = racingCars.racingCars[i].getPosition();
            System.out.println("-".repeat(position));
        }
    }
    public static int scanScarCount() {
        return scanInputCount("자동차 대수는 몇 대 인가요?");
    }
    public static int scanRoundCount() {
        return scanInputCount("시도할 횟수는 몇 회 인가요?");
    }
    private static int scanInputCount(String x) {
        System.out.println(x);
        int participantCarCount = scanner.nextInt();
        return participantCarCount;
    }
}
