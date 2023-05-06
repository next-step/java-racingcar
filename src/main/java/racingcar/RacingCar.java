package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int tryAmount = InputView.getTryAmount();
        List<Car> cars = createCar(carNames);

        Game game = new Game(cars);
        OutputView.printExecutionResult();
        for (int i = 0; i < tryAmount; i++) {
            game.play();
            OutputView.printCarPosition(cars);
        }
        OutputView.printWinner(game.getWinner());
    }

    private static List<Car> createCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
