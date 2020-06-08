package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Race {
    private final Cars cars;
    private final int rounds;
    private final List<Result> results = new ArrayList<>();

    public Race(Cars cars, int rounds) {
        valid(cars, rounds);
        this.cars = cars;
        this.rounds = rounds;
    }

    public void start(Fuel fuel) {
        for (int round = 0; round < rounds; round++) {
            Game game = new Game(cars, round);
            results.add(game.start(fuel));
        }
    }

    public List<Result> getResults() {
        return results;
    }

    private void valid(Cars cars, int rounds) {
        if(cars == null || rounds == 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return rounds == race.rounds &&
                Objects.equals(cars, race.cars) &&
                Objects.equals(results, race.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, rounds, results);
    }



}