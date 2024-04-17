package step4_winner;


import java.util.List;
import java.util.Random;

public class Race {
    private final Random random = new Random();
    private final List<Car> cars;

    public Race(List<Car> cars) {
        if (cars.isEmpty())
            throw new IllegalArgumentException("0이상이어야 함");
        this.cars = cars;
    }

    public void runRound() {
        cars.forEach(car -> car.move(random.nextInt(10)));
    }
}
