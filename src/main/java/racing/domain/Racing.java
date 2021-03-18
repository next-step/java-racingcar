package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    final private Cars cars;
    final private Rounds rounds;

    public Racing(String[] carNames) {
        this(new Cars(carNames), new Rounds());
    }

    public Racing(Cars cars, Rounds rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void runRace() {
        cars.tryMoveAll();
        rounds.add(new Round(cars));
    }

    public boolean hasRun(int count) {
        return rounds.size() < count;
    }

    public Rounds getRounds() {
        return rounds;
    }

    public List<Car> getWinnerList() {
        final Round lastRound = rounds.getLast();

        if (lastRound == null) {
            return new ArrayList<>();
        }

        return lastRound.getLeaderList();
    }
}