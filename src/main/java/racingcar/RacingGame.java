package racingcar;

import java.util.List;

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
