package race.domain;

import race.view.InputView;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        new RacingGame().race(new CarFactory().createCars(inputView.inputCar()), inputView.inputTry());
    }
}
