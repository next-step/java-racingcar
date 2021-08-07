package racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Race {
    private int round;
    private List<Car> cars;
    protected List<List<Integer>> posForEachRound;

    public Race(int carNum, int round) {
        this.round = round;
        this.cars = new LinkedList<>();
        this.posForEachRound = new LinkedList<>();
        crateCars(carNum);
    }

    private void crateCars(int carNum) {
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
    }

    public void doRace() {
        for (int i = 0; i < round; i++) {
            raceForRound();
            saveRoundResult();
        }
    }

    private void raceForRound() {
        cars.stream().forEach(car-> car.move(new RandomNumGenerator().getRandomNumber()));
    }

    private void saveRoundResult() {
        List<Integer> posForRound = new LinkedList<>();
        cars.stream().forEach(car-> posForRound.add(car.getPosition()));
        posForEachRound.add(posForRound);
    }
}
