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

    public List<Car> getWinners() {
        if (rounds.get() > 0) {
            throw new IllegalStateException("Race not ended. Lap remains: " + rounds + " rounds left.");
        }

        int max = 0;
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMiles() > max) {
                max = car.getMiles();
                winners = new ArrayList<>();
                winners.add(car);
                continue;
            }

            if (car.getMiles() == max) {
                winners.add(car); // add ties
            }
        }
        return winners;
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
