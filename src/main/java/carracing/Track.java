package carracing;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Track {

    private final RandomFactory randomFactory;
    private final List<Car> cars;
    private final List<Round> rounds;

    public Track(List<Car> cars) {
        this.cars = cars;
        this.rounds = new LinkedList<>();
        this.randomFactory = new RandomFactory();
    }

    public void forward() {
        cars.forEach(car -> {
            int random = this.randomFactory.generate(Car.RANDOM_BOUND);
            car.stepForwardByRandomNumber(random);
        });
        List<Integer> steps = cars.stream()
                .map(Car::getStep)
                .collect(Collectors.toList());
        rounds.add(new Round(steps));
    }

    public List<Round> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

    public static class Round {
        private List<Integer> steps;

        public Round(List<Integer> steps) {
            this.steps = steps;
        }

        public List<Integer> getSteps() {
            return Collections.unmodifiableList(steps);
        }
    }
}
