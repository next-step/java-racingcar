package race.applicantion;

import race.domain.Racing;
import race.domain.RacingCars;
import race.exception.IncorrectCarNameException;
import race.view.ConsoleView;

public class RaceApplication {

    public static void main(String[] args) {
        String carNames = ConsoleView.inputCarNames();
        int numOfTry = ConsoleView.inputNumOfTry();

        try {
            race(carNames, numOfTry);
        } catch (IncorrectCarNameException e) {
            ConsoleView.showError(e.getMessage());
        }
    }

    private static void race(String strCarNames, int numOfTry) {
        RacingCars cars = RacingCars.createRandomMoveCars(strCarNames);
        Racing racing = new Racing(cars);
        for (int i = 0; i < numOfTry; i++) {
            racing.play();
            ConsoleView.showResult(cars);
        }
        ConsoleView.showWinners(racing.judgeWinners());
    }
}
