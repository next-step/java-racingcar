package racingcar;

import racingcar.io.InputView;
import racingcar.io.OutputView;
import racingcar.model.Car;
import racingcar.model.RacingCar;

import java.util.List;

public class RacingCarApplication {

    private static RacingCar racingCar;

    public static void main(String[] args) {
        OutputView.start();
        int carCount = InputView.askCarCount();
        int time = InputView.askTime();
        racingCar = RacingCar.generate(time, carCount);

        System.out.println("실행결과");
        while (!racingCar.isGameOver()){
            OutputView.playResult(racingCar.init());
            List<Car> cars = racingCar.play();
            OutputView.playResult(cars);
        }
        OutputView.end();
    }
}
