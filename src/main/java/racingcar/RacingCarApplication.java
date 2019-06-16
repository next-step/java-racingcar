package racingcar;

import racingcar.io.InputView;
import racingcar.io.OutputView;
import racingcar.model.RacingCar;

public class RacingCarApplication {

    private static RacingCar racingCar;

    public static void main(String[] args) {
        OutputView.start();
        int carCount = InputView.askCarCount();
        int time = InputView.askTime();
        racingCar = RacingCar.generate(time, carCount);

        OutputView.result();
        while (!racingCar.isGameOver()){
            OutputView.playResult(racingCar.init());
            OutputView.playResult(racingCar.play());
        }
        OutputView.end();
    }
}
