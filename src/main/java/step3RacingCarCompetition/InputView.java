package step3RacingCarCompetition;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<Integer> insertRacingCarData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int movingTryCount = scanner.nextInt();

        return List.of(numberOfCars, movingTryCount);
    }

}
