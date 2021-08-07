package racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Race {
    private List<Round> rounds;
    private Cars cars;
    private int roundNum;

    public Race(int carNum, int roundNum) {
        cars = new Cars(carNum);
        this.roundNum = roundNum;
        rounds = new LinkedList<>();
    }

    public void doRace() {
        for (int i = 0; i < roundNum; i++) {
            Round round = new Round(this.cars);
            this.cars = round.moveCars();
            rounds.add(round);
        }
    }
}
