package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    final Random RANDOM = new Random();
    final int MAX_RANDOM_VALUE = 10;

    public void StartRacingGame() {

        InputView inputView = InputView.getInstance();
        ResultView resultView = ResultView.getInstance();

        List<Car> cars = new ArrayList<Car>();
        int carCount = inputView.requestCarCount();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        int moveCount = inputView.requestCarMovementCount();

        resultView.showRacingGameResultComment();
        for (int i = 0; i < moveCount; i++) {
            executeRacing(cars, resultView);
            resultView.showRacingRoundEndComment();
        }
    }

    private void executeRacing(List<Car> cars, ResultView resultView) {
        for (Car car : cars) {
            car.move(RANDOM.nextInt(MAX_RANDOM_VALUE));
            resultView.showResultComment(car.getPosition());
        }
    }
}
