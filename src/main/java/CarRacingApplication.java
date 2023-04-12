import static domain.Cars.getEachCarMovedDistance;
import static view.InputView.getInput;
import static view.ResultView.drawDistanceBlock;
import static view.ResultView.drawResultView;

import domain.Cars;
import domain.UserInput;

public class CarRacingApplication {

    public static void main(String[] args) {
        run(getInput());
    }

    private static void run(UserInput userInput) {
        int attemptCount = userInput.getAttemptCount();
        createResult(new Cars(userInput), attemptCount);
    }

    private static void createResult(Cars cars, int attemptCount) {
        drawResultView();
        for (int i = 0; i < attemptCount; i++) {
            cars.makeCarsMove();
            drawDistanceBlock(getEachCarMovedDistance(cars));
        }
    }
}
