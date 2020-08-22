package race.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Circuit {

    private static final Random random = new Random();

    private final AtomicInteger rounds;
    private List<Car> cars = new ArrayList<>();


    public Circuit(List<String> names, int rounds) {
        this.rounds = new AtomicInteger(rounds);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public boolean lap() {
        if (rounds.getAndDecrement() > 0) {
            cars.forEach(car -> car.advance(this::canAdvance));
            return true;
        }
        return false;
    }

    public List<Car> getWinners() {
        if (rounds.get() > 0) {
            throw new IllegalStateException("Race not ended. Lap remains: " + rounds + " rounds left.");
        }

        int max = getMaxMiles();
        return cars.stream()
            .filter(car -> car.getMiles() == max)
            .collect(Collectors.toList());
    }

    private int getMaxMiles() {
        return cars.stream()
            .max(Comparator.comparingInt(Car::getMiles))
            .orElseThrow(()
                -> new IllegalStateException("Cannot get max miles from cars.stream(). Stream may be empty."))
            .getMiles();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getRounds() {
        return rounds.get();
    }

    private boolean canAdvance() {
        return random.nextInt(10) >= 4;
    }
}
