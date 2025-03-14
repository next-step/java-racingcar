package racing;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GrandPrix {
    private int currentRound;
    private final List<Round> rounds;
    private final List<Car> cars;

    public GrandPrix(int totalRound, int totalCars, Random random) {
        this.currentRound = 0;
        this.rounds = IntStream.range(0, totalRound)
                .mapToObj(i -> new Round(random))
                .collect(Collectors.toUnmodifiableList());
        this.cars = IntStream.range(0, totalCars)
                .mapToObj(i -> new Car())
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isFinished() {
        return rounds.stream()
                .allMatch(Round::isFinished);
    }

    public void play() {
        rounds.get(currentRound).play(cars);
        currentRound++;
    }

    public Map<Integer, Integer> report() {
        // sould return car index and car position
        return IntStream.range(0, cars.size())
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> cars.get(i).getPosition()));
    }

}
