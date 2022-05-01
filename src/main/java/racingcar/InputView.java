package racingcar;

import java.util.Scanner;

public class InputView {
    private static int numberOfCars;
    private static int numberOfGames;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("자동차 대수는 몇 대 인가요?");
        numberOfCars = scanner.nextInt();

        System.out.print("시도할 횟수는 몇 회 인가요?");
        numberOfGames = scanner.nextInt();

        RacingGame.racing(numberOfCars, numberOfGames);
    }
}
