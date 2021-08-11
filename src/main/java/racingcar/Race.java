package racingcar;


import java.util.List;

public class Race {
    private final Rounds rounds;
    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public Race(int carNum, int roundNum, MoveStrategy moveStrategy) {
        this.cars = new Cars(carNum);
        this.rounds = new Rounds(roundNum);
        this.moveStrategy = moveStrategy;
    }

    public void doRace() {
        rounds.moveCarsForEachRound(cars, moveStrategy);
    }

    public List<List<Integer>> getCarsPositionPerRound() {
        return rounds.getCarsPositionForEachRound();
    }
}
