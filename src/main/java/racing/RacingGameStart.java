package racing;

import racing.view.InputView;

public class RacingGameStart {

    public static void main(String[] args) {
        int cars = InputView.inputCar();
        int times = InputView.inputTime();

        RacingCars racingCars = new RacingCars(cars);

        RacingGame racingGame = new RacingGame(racingCars, times);
        racingGame.race();


    }
}
