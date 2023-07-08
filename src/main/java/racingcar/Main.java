package racingcar;

import racingcar.car.CarRacingGame;
import racingcar.car.view.InputView;

public class Main {

    public static void main(String[] args) {
        CarRacingGame racingGame = new CarRacingGame();
        racingGame.play(InputView.getCarNames(), InputView.getPlayCount());
    }
}
