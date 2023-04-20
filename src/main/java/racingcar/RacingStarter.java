package racingcar;

import java.util.List;

public class RacingStarter {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int requestedCarNums = inputView.requestCarNums();
        int requestedMoveNums = inputView.requestMoveNums();

        List<Car> cars = Racing.create(requestedCarNums);
        Racing racing = new Racing(requestedCarNums, requestedMoveNums);

        for (int i = 0; i < requestedMoveNums; i++) {
            racing.race(cars);
            resultView.openResults(cars);
        }
    }
}
