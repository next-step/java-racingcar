package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

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

    List<Car> getCars() {
        return this.cars;
    }

    int getRounds() {
        return rounds.get();
    }

    private boolean canAdvance() {
        return random.nextInt(10) >= 4;
    }
}
