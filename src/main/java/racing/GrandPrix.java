package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GrandPrix {
    private int currentRound;
    private final List<Round> rounds;
    private final List<Car> cars;

    public GrandPrix(int totalRound, int totalCars) {
        this.currentRound = 0;
        this.rounds = IntStream.range(0, totalRound)
                               .mapToObj(i -> new Round(new ZeroToTenDice()))
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

    public Reports report() {
        return new Reports(cars);
    }
}
