package racingcar.ui;

import racingcar.domain.Cars;
import racingcar.domain.Record;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingController {
    public static final int FIRST = 1;

    private int tryCount;
    private Cars cars;
    private Record record;

    public RacingController(InputView inputView) {
        this.cars = new Cars(inputView.getCarNames());
        tryCount = inputView.getTryCount();
        record = new Record();
    }

    public void startGame() {
        gameStart();
        showResult();
    }

    private List<Integer> changePosition() {
        Cars move = cars.move();
        cars = move;
        return move.getPositions();
    }

    private void gameStart() {
        for (int count = FIRST; count <= tryCount; count++) {
            record.add(count, changePosition());
        }
    }

    private void showResult() {
        ResultView resultView = new ResultView(this.record, this.cars);
        resultView.show();
    }


}
