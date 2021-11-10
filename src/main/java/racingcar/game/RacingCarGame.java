package racingcar.game;

import racingcar.domain.Cars;
import racingcar.gameinfo.GameInfo;

public class RacingCarGame {

    private final GameInfo info;
    private final Cars cars;

    public RacingCarGame(GameInfo info) {
        this.info = info;
        this.cars = info.getCars();
    }

    public void start() {
        for(int count = 0; count < this.info.getTryCount() ; count++){
            cars.playGame(this.info.getMoveRule());
            cars.printRoundResult(info.getResultView());
        }
        cars.printWinner(info.getResultView());
    }
}