package racing;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tries = scanner.nextInt();

        RacingScoreView view = new RacingScoreView(new RacingGame(numberOfCars, tries).doRace());
        view.printResult();

    }

}
