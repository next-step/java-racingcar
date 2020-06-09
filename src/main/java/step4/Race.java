package step4;

import java.util.Objects;

public class Race {

    private final Cars cars;
    private final int rounds;

    public Race(Cars cars, int rounds) {
        valid(cars, rounds);
        this.cars = cars;
        this.rounds = rounds;
    }

    public void start() {
        OutputView.start();
        for (int round = 1; round <= rounds; round++) {
            Game game = new Game(cars, round);
            Result result = game.start();
            OutputView.render(result);
            if(round == rounds) {
                OutputView.winner(result);
            }
        }
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
                Objects.equals(cars, race.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, rounds);
    }
}