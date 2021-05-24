package car;

import car.domain.Car;
import car.domain.Game;
import car.view.Input;

import java.util.List;

public class CarApp {
    public static void main(String[] args) {
        Game game = new Game();
        Input input = new Input(game);

        List<Car> cars = input.inputCarNames();

        String count = input.inputTryCount();

        game.excute(cars, count);
    }
}
