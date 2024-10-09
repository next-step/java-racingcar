package racingcar;

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

        ResultView resultView = new ResultView();
        Racing racing = new Racing(cars);

        for (int i = 0; i < roundNum; i++) {
            resultView.roundStart(i + 1);
            List<RacingResult> carPositions = racing.play();
            resultView.drawCarPositions(carPositions);
        }
        List<Car> winners = Winners.findWinners(cars);
        resultView.printWinners(winners);
    }

}
