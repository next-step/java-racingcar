package racingcar.domain.aggregate;

import racingcar.domain.collection.CarGroup;
import racingcar.domain.collection.History;
import racingcar.domain.model.Car;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomStrategy;

import java.util.List;

/**
 * NOTE: 루트 어그리게이트
 * racingcar.controller.Main 에서 모델의 실제 데이터에 접근할 때는,
 * RacingGame 레포지토리 객체를 만들어 접근해야만 한다.
 */

public class RacingGame {
    private History history;
    private CarGroup carGroup;
    private int currRaceNum;
    private int maxRaceNum;

    public RacingGame(String nameCsv, int maxRaceNum) {
        MoveStrategy defaultStrategy = RandomStrategy.getInstance();
        carGroup = new CarGroup(nameCsv, defaultStrategy);
        this.maxRaceNum = maxRaceNum;
        history = new History();
    }

    public void setStrategy(MoveStrategy strategy) {
        carGroup.setStrategy(strategy);
    }

    protected boolean checkGameOver() {
        return currRaceNum >= maxRaceNum;
    }

    protected void race() {
        if (checkGameOver()) {
            return;
        }
        currRaceNum++;
        carGroup.moveCar();
        history.add(
                carGroup.createMemento()
        );
    }

    public void play() {
        while (!checkGameOver()) {
            race();
        }
    }

    public History getHistory() {
        return history;
    }

    public List<Car> getWinners() {
        return carGroup.getWinners();
    }
}
