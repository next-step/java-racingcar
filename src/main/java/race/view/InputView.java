package race.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    public static int askNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = SCANNER.nextInt();
        if (numberOfCars < 0) {
            throw new IllegalArgumentException(String.format("(%d)은/는 음수입니다.", numberOfCars));
        }
        return numberOfCars;
    }

    public static int askNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int attempts = SCANNER.nextInt();
        if (attempts < 0) {
            throw new IllegalArgumentException(String.format("(%d)은/는 음수입니다.", attempts));
        }
        return attempts;
    }

}
