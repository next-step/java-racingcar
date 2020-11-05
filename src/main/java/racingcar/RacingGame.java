package racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    List<Memento> mementos;
    private CarGroup carGroup;
    private int currRace;
    private int maxRace;

    public RacingGame(String nameCsv, int maxRaceNum) {
        MoveStrategy defaultStrategy = RandomStrategy.getInstance();
        this.carGroup = new CarGroup(nameCsv, defaultStrategy);
        this.currRace = 0;
        this.maxRace = maxRaceNum;
        this.mementos = new LinkedList<>();
    }

    public void setStrategy(MoveStrategy strategy) {
        this.carGroup.setStrategy(strategy);
    }

    protected boolean checkNotGameOver() {
        return this.currRace < this.maxRace;
    }

    protected void race() {
        if (!this.checkNotGameOver()) {
            return;
        }
        this.currRace++;
        this.carGroup.moveCar();
        this.mementos.add(
                this.carGroup.createMemento()
        );
    }

    public void play() {
        while (this.checkNotGameOver()) {
            this.race();
        }
    }

    public List<List<Car>> getHistory() {
        return this.mementos.stream()
                .map(memento -> memento.getCars())
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        return this.carGroup.getWinners();
    }
}
