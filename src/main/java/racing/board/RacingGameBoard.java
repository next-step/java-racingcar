package racing.board;

import racing.model.RacingCar;
import racing.random.BoundedRandomGenerator;
import racing.random.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

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

    public int createCars(int size) {
        for (int i = 0 ; i < size; i++) {
            cars.add(new RacingCar());
        }
        return cars.size();
    }

    public List<Integer> moveCars() {
        List<Integer> positions = new ArrayList<>();
        for (RacingCar car : cars) {
            positions.add(car.move(randomGenerator.nextInt()));
        }
        return positions;
    }
}
