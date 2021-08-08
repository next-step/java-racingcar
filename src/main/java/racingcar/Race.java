package racingcar;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Race {
    private Rounds rounds;
    private Cars cars;
    private MoveRule moveRule;

    public Race(int carNum, int roundNum, MoveRule moveRule) {
        this.cars = new Cars(carNum);
        this.rounds = new Rounds(roundNum);
        this.moveRule = moveRule;
    }

    public void doRace() {
        rounds.moveCarsForEachRound(cars, moveRule);
    }

    public List<List<String>> getCarsPositionPerRound() {
        return rounds.getCarPositionForEachRound();
    }
}
