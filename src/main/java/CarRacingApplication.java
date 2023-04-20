import static domain.Cars.createCars;
import static view.InputView.getInput;
import static view.ResultView.WINNER_DELIMITER;
import static view.ResultView.drawDistanceBlockWithName;
import static view.ResultView.drawFirstPlace;
import static view.ResultView.drawResultView;

import domain.Cars;
import domain.UserInput;
import domain.Winners;

public class CarRacingApplication {

    public static void main(String[] args) {
        run(getInput());
    }

    private static void run(UserInput userInput) {
        int attemptCount = userInput.getAttemptCount();
        Cars cars =createCars(userInput.getNamesForCars());
        createResult(cars, attemptCount);
    }

    private static void createResult(Cars cars, int attemptCount) {
        drawResultView();

        for (int i = 0; i < attemptCount; i++) {
            cars.makeCarsMove();
            drawDistanceBlockWithName(cars);
        }

        String winnersNames = new Winners(cars).makeWinnersString(WINNER_DELIMITER);
        drawFirstPlace(winnersNames);
    }
}
