import static domain.Cars.createCars;
import static view.InputView.getInput;
import static view.ResultView.drawDistanceBlockWithName;
import static view.ResultView.drawFirstPlace;
import static view.ResultView.drawResultView;

import domain.Car;
import domain.Cars;
import domain.UserInput;
import java.util.List;

public class CarRacingApplication {

    public static void main(String[] args) {
        run(getInput());
    }

    private static void run(UserInput userInput) {
        int attemptCount = userInput.getAttemptCount();
        List<Car> cars = createCars(userInput.getNamesForCars(), userInput.getNumbersOfCar());
        createResult(new Cars(cars), attemptCount);
    }

    private static void createResult(Cars cars, int attemptCount) {
        drawResultView();
        for (int i = 0; i < attemptCount; i++) {
            cars.makeCarsMove();
            drawDistanceBlockWithName(cars);
        }
        drawFirstPlace(cars);
    }
}
