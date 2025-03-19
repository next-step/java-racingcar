package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GrandPrix {
    private int currentRound;
    private final List<Round> rounds;
    private final List<Car> cars;

    public GrandPrix(int totalRound, List<String> names) {
        this(totalRound, names, new ZeroToTenDice());
    }

    GrandPrix(int totalRound, List<String> names, Dice dice) {
        this.currentRound = 0;
        this.rounds = IntStream.range(0, totalRound)
                               .mapToObj(i -> new Round(dice))
                               .collect(Collectors.toUnmodifiableList());
        this.cars = names.stream()
                .map(Car::new)
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

    public Report report() {
        return new Report(cars);
    }

    public Integer getCarCount() {
        return cars.size();
    }

    public List<String> findChampions() {
        return cars.stream().map(Car::getName).collect(Collectors.toUnmodifiableList());
    }
}
