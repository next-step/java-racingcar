package racingcar.application;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.carNames();
        int tryNum = InputView.tryTime();

        Racing racing = new Racing(carNames, tryNum);

        ResultView.results(racing.getRacingCars(), racing.startRace());
        ResultView.whoIsWinner(racing.getRacingCars());
    }
}
