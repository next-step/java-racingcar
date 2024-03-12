package step3;

import java.util.List;
import java.util.Scanner;

public class RacingGameApplication {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfAttempts = scanner.nextInt();

        Race race = new Race(new RandomPolicy(),numberOfCar,numberOfAttempts);

        List<RoundResultMap> finalResult = race.start();

        race.printResult(finalResult);
    }
}
