package racing;

import racing.domain.Cars;
import racing.domain.GameRunner;
import racing.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.requestCarNames();
        Cars cars = new Cars(carNames);
        int numberOfMove = inputView.requestNumberOfMove();
        GameRunner gameRunner = new GameRunner(cars, numberOfMove);
        gameRunner.play();
    }
}
