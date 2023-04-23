import static domain.Cars.createCars;
import static view.InputView.getInput;
import static view.ResultView.drawDistanceBlockWithName;
import static view.ResultView.drawFirstPlace;
import static view.ResultView.drawResultView;

import domain.Cars;
import domain.UserInput;
import domain.Winners;

import java.util.stream.IntStream;

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

        IntStream.range(0, attemptCount).forEach(i -> {
            cars.makeCarsMove();
            drawDistanceBlockWithName(cars);
        });

        drawFirstPlace(new Winners(cars).winnersName());
    }
}
