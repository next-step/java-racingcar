package racingcar.Service;

import racingcar.model.Board;
import racingcar.model.Cars;
import racingcar.model.RacingInfo;
import racingcar.view.ResultView;

public class RacingGame {
    private final RacingInfo racingInfo;
    private final Cars cars;
    private Board board;

    public RacingGame(RacingInfo racingInfo, Cars cars) {
        this.racingInfo = racingInfo;
        this.cars = cars;
        this.board = new Board();
    }

    public ResultView gameStart() {
        for (int i = 0; i < racingInfo.raceTrialCount; i++) {
            cars.movable();
            board.record(cars.getCarsPositions());
        }
        return new ResultView(board);
    }
}
