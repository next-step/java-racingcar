package carracing;

import java.util.*;

public class Track {

    private final List<Car> cars;
    private final List<Round> rounds;

    public Track(List<Car> cars) {
        this.cars = cars;
        this.rounds = new LinkedList<>();
    }

    public void forward() {
        cars.forEach(car -> {
            int random = RandomFactory.generate(Car.RANDOM_BOUND);
            car.stepForwardByRandomNumber(random);
        });
        rounds.add(new Round(cars));
    }

    public List<Round> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

    public static class Round {
        private final Map<CarName, Integer> nameToStep;

        public Round(List<Car> cars) {
            nameToStep = new HashMap<>();
            cars.forEach(car -> {
                nameToStep.put(car.getCarName(), car.getStep());
            });
        }

        public Map<CarName, Integer> getSteps() {
            return Collections.unmodifiableMap(nameToStep);
        }
    }
}
