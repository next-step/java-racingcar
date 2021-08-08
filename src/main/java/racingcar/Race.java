package racingcar;


import java.util.List;

public class Race {
    private Rounds rounds;
    private Cars cars;
    private MoveStrategy moveStrategy;

    public Race(int carNum, int roundNum, MoveStrategy moveStrategy) {
        this.cars = new Cars(carNum);
        this.rounds = new Rounds(roundNum);
        this.moveStrategy = moveStrategy;
    }

    public void doRace() {
        rounds.moveCarsForEachRound(cars, moveStrategy);
    }

    public List<List<String>> getCarsPositionPerRound() {
        return rounds.getCarPositionForEachRound();
    }
}
