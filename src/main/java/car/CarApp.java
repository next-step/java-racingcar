package car;

import car.domain.Cars;
import car.domain.Game;
import car.view.Input;

public class CarApp {
    public static void main(String[] args) {
        Game game = new Game();
        Input input = new Input(game);

        Cars cars = input.inputCarNames();

        String count = input.inputTryCount();

        game.excute(cars, count);
    }
}
