package racing.board;

import racing.model.NamedRacingCar;
import racing.model.RacingCar;
import racing.random.BoundedRandomGenerator;
import racing.random.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameBoard {

    private static final int RANDOM_UPPER_BOUND = 10;

    private final List<RacingCar> cars;

    private RandomGenerator randomGenerator;

    public RacingGameBoard() {
        this(new BoundedRandomGenerator(RANDOM_UPPER_BOUND));
    }

    public RacingGameBoard(RandomGenerator randomGenerator) {
        cars = new ArrayList<>();
        this.randomGenerator = randomGenerator;
    }

    public int createCars(List<String> names) {
        cars.addAll(names.stream()
                .map(name -> new NamedRacingCar(name))
                .collect(Collectors.toList()));
        return cars.size();
    }

    public GameResult start(int timesOfMoves) {
        GameResult result = new GameResult();

        for (int i = 0; i < timesOfMoves; i++) {
            moveCars();
            result.addStep(cars);
        }

        return result;
    }

    private void moveCars() {
        for (RacingCar car : cars) {
            car.move(randomGenerator.nextInt());
        }
    }
}
