package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputCarAmount();
        inputView.inputTryAmount();

        List<Car> cars = getCars(inputView);

        Game game = new Game(cars);
        OutputView.printExecutionResult();
        for (int i = 0; i < inputView.getTryAmount(); i++) {
            game.play();
            OutputView.printCarPosition(game.getCars());
        }
    }

    private static List<Car> getCars(InputView inputView) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputView.getCarAmount(); i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
