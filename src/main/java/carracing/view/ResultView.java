package carracing.view;

import carracing.domain.car.Cars;
import carracing.domain.car.Winners;
import carracing.domain.game.RacingGame;

public class ResultView {
    public static void printResultPhrase() {
        System.out.println("실행 결과");
    }

    public static void printMovingResult(RacingGame racingGame) {
        Cars racingCars = racingGame.cars();
        racingCars.printMovingResult();
        empty();
    }

    public static void empty() {
        System.out.println("");
    }

    public static void printWinners(Winners winners) {
        winners.printWinners();
    }
}
