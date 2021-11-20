package carracing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Track {
    private static final int RANDOM_BOUND = 10;

    private final List<Car> cars;
    private final Random random;

    public Track(int cars) {
        this.cars = new ArrayList<>(cars);
        for (int i = 0; i < cars; i++) {
            this.cars.add(new Car());
        }

        this.random = new Random();
    }

    public List<Integer> getSteps() {
        List<Integer> steps = cars.stream()
                .map(Car::getStep)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(steps);
    }

    public void forward() {
        cars.forEach(car -> {
            int random = this.random.nextInt(RANDOM_BOUND);
            car.stepForwardByRandomNumber(random);
        });
    }

    public void printSteps(StepPrint stepPrint) {
        cars.forEach(car -> stepPrint.print(car.getStep()));
        stepPrint.delimiter();
    }
}
