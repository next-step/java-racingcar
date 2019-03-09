package racing.board;

import racing.model.RacingCar;
import racing.random.BoundedRandomGenerator;
import racing.random.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGameBoard {

    private static final int RANDOM_UPPER_BOUND = 10;

    private final List<RacingCar> cars;

    RandomGenerator randomGenerator;

    public RacingGameBoard() {
        this(new BoundedRandomGenerator(RANDOM_UPPER_BOUND));
    }

    public RacingGameBoard(RandomGenerator randomGenerator) {
        cars = new ArrayList<>();
        this.randomGenerator = randomGenerator;
    }

    public void createCars(int count) {
        for (int i = 0 ; i < count; i++) {
            cars.add(new RacingCar());
        }
    }

    public void moveCars() {
        for (RacingCar car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(RacingCar car) {
        car.move(randomGenerator.nextInt());
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendCars(sb);
        return sb.toString();
    }

    private void appendCars(StringBuilder sb) {
        for (RacingCar car : cars) {
            appendCar(sb, car);
        }
    }

    private void appendCar(StringBuilder sb, RacingCar car) {
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        sb.append("\n");
    }
}
