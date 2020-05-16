package racing.fake;

import racing.domain.Car;
import racing.domain.CarMovement;
import racing.domain.RacingGame;
import racing.domain.RandomMovement;
import racing.dto.RaceInformation;

import java.util.List;
import java.util.Random;

public class FakeRacingGame extends RacingGame {
    private List<Car> fakeCars;

    public FakeRacingGame(List<Car> fakeCars) {
        super(new RaceInformation(5, new String[] {"test", "test2"}), new RandomMovement(new Random()));
        this.fakeCars = fakeCars;
    }

    @Override
    public int calculateMaxPosition() {
        return this.fakeCars.stream()
                .map(car -> car.findCurrentPosition())
                .max(Integer::compareTo)
                .orElse(0);
    }
}
