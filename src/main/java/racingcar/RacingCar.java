package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    public static void main(String[] args) {
        int carAmount = InputView.getCarAmount();
        int tryAmount = InputView.getTryAmount();
        List<Car> cars = createCar(carAmount);

        Game game = new Game(cars);
        OutputView.printExecutionResult();
        for (int i = 0; i < tryAmount; i++) {
            game.play();
            OutputView.printCarPosition(cars);
        }
    }

    private static List<Car> createCar(int carAmount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carAmount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
