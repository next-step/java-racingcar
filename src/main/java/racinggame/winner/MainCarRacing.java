package racinggame.winner;

import java.util.Scanner;

public class MainCarRacing {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Cars cars = InputView.readCars(scanner);
            RacingCount count = InputView.readRacingCount(scanner);
            RacingGame game = new RacingGame(cars, count);

            System.out.println();
            System.out.println("실행 결과");
            while (!game.isFinish()) {
                game.race();
                ResultView.printRound(cars.getCars());
            }
            ResultView.printWinners(game.getWinners());
        }
    }
}
