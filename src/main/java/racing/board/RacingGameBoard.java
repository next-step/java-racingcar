package racing.board;

import racing.model.NamedRacingCar;
import racing.model.RacingCar;
import racing.random.BoundedRandomGenerator;
import racing.random.RandomGenerator;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
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
                .map(name -> new NamedRacingCar(name.trim()))
                .collect(Collectors.toList()));
        return cars.size();
    }

    public GameResult start(int timesOfMoves) {
        if (timesOfMoves < 1) throw new IllegalArgumentException("timesOfMoves should greater than 0");

        int maxPosition = runSteps(timesOfMoves);

        return new GameResult(cars
            .stream()
            .filter(cars -> cars.isAt(maxPosition))
            .map(RacingCar::toString)
            .collect(Collectors.toList()));
    }

    private int runSteps(int times) {
        int maxPosition = 0;
        for (int i = 0; i < times; i++) {
            maxPosition = runStep();
        }
        return maxPosition;
    }

    private int runStep() {
        List<Integer> positions = new ArrayList<>();

        moveCars(position -> positions.add(position));
        ResultView.viewNextStep();

        return maxPosition(positions);
    }

    private int maxPosition(List<Integer> positions) {
        return Collections.max(positions);
    }

    private void moveCars(IntConsumer moveCallback) {
        for (RacingCar car : cars) {
            int position = moveCar(car, ResultView::viewStep);
            moveCallback.accept(position);
        }
    }

    private int moveCar(RacingCar car, BiConsumer<String, Integer> viewCallback) {
        int position = car.move(randomGenerator.nextInt());
        viewCallback.accept(car.toString(), position);
        return position;
    }
}
