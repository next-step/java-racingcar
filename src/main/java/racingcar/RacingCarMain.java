package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.RacingResult;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarMain {

    public static void main(String[] args) {
        String[] names = InputView.getCarNames();
        int roundNum = InputView.getRoundNumber();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        Racing racing = new Racing(cars);

        for (int i = 0; i < roundNum; i++) {
            ResultView.roundStart(i + 1);
            List<RacingResult> carPositions = racing.play();
            ResultView.drawCarPositions(carPositions);
        }
        List<Car> winners = Winners.findWinners(cars);
        ResultView.printWinners(winners);
    }

}
