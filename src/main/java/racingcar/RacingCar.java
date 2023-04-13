package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    public static final int BOUND = 10;
    public static final int PROCEEDING_NUM = 4;

    public static final Random random = new Random();

    public static void inputView() {
        Scanner scanner = new Scanner(System.in);

        Integer carCount = getCarCount(scanner);
        Integer trialCount = getTrialCount(scanner);

        System.out.println("carCount = " + carCount);
        System.out.println("trialCount = " + trialCount);
    }

    private static Integer getCarCount(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    private static Integer getTrialCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int proceed() {
        int number = random.nextInt(BOUND);
        return number >= PROCEEDING_NUM ? 1 : 0;
    }

    public static void race(int[][] car) {
        for(int[] row : car) {
            row[0] = 1;
            for(int j=1; j < row.length; j++) {
                row[j] += row[j-1] + proceed();
            }
        }
    }
}
