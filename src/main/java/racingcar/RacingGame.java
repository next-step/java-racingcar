package racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    List<Memento> mementos;
    private CarGroup carGroup;
    private int currTry;
    private int maxTry;

    public RacingGame(String nameCsv, int tryNum) {
        MoveStrategy strategy = new RandomMoveStrategy();
        this.carGroup = new CarGroup(nameCsv, strategy);
        this.currTry = 0;
        this.maxTry = tryNum;
        this.mementos = new LinkedList<>();
    }

    public boolean checkNotGameOver() {
        return this.currTry < this.maxTry;
    }

    public void play() {
        if (!this.checkNotGameOver()) {
            return;
        }
        this.currTry++;
        this.carGroup.moveCar();
        this.mementos.add(
                this.carGroup.createMemento()
        );
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
