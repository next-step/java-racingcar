package racingcar;

import java.util.List;
import java.util.Scanner;

public class RaceGameApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int gameCount = scanner.nextInt();

        RaceGame raceGame = new RaceGame(carCount, gameCount);
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            raceGame.playRound();
            printRoundResult(raceGame.cars());
            System.out.println();
        }
    }

    private static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.position()));
        }
    }
}
