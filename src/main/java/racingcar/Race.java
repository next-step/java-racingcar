package racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Race {
    private Rounds rounds;
    private Cars cars;

    public Race(int carNum, int roundNum) {
        cars = new Cars(carNum);
        rounds = new Rounds(roundNum);
    }

    public void doRace() {
        rounds.moveCarsForEachRound(cars);
    }
}
