package racing;

import racing.domain.CarRandomNumberGenerator;
import racing.domain.Cars;
import racing.domain.GameRunner;
import racing.domain.RandomNumberGenerator;
import racing.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.requestCarNames();
        int numberOfMove = inputView.requestNumberOfMove();
        Cars cars = new Cars();
        cars.generateCarsWithName(carNames);
        GameRunner gameRunner = new GameRunner(cars, numberOfMove);
        RandomNumberGenerator randomNumberGenerator = new CarRandomNumberGenerator();
        gameRunner.play(randomNumberGenerator);
    }
}
