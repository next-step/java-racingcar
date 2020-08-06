package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Circuit {

    private final int count;
    private final AtomicInteger rounds;
    private List<Car> cars = new ArrayList<>();

    public Circuit(int count, int rounds) {
        this.count = count;
        this.rounds = new AtomicInteger(rounds);
        for (int i = 0; i < this.count; i++) {
            cars.add(new Car());
        }
    }

    public boolean lap() {
        if (rounds.getAndDecrement() > 0) {
            cars.forEach((Car::advance));
            return true;
        }
        return false;
    }

    public void printStatus() {
        cars.forEach(car -> {
            System.out.println(car.getMiles());
        });
    }

}
