package racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Race {
    private List<Round> rounds;
    private List<Car> cars;
    private int roundNum;

    public Race(int carNum, int roundNum) {
        crateCars(carNum);
        this.roundNum = roundNum;
        rounds = new LinkedList<>();
    }

    private void crateCars(int carNum) {
        cars = new LinkedList<>();
        IntStream.range(0, carNum).forEach(i -> cars.add(new Car()));
    }

    public void doRace() {
        for (int i = 0; i < roundNum; i++) {
            Round round = new Round(this.cars);
            this.cars = round.moveCars();
            rounds.add(round);
        }
    }
}
