package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {
    final int carNumber;

    final int iterate;

    private final List<Car> cars = new ArrayList<Car>();

    public Racing(int carNumber, int iterate) {
        this.carNumber = carNumber;
        this.iterate = iterate;
        this.createParticipants();
    }

    public void start() {
        for (int i = 0; i < iterate; i++) {
            this.runRound();
        }
    }

    private void createParticipants() {
        for (int i = 0; i < this.carNumber; i++) {
            this.cars.add(new Car());
        }
    }

    private void runRound() {
        this.cars.forEach(Car::moveByRandomOnRound);
    }

    public List<Car> getRacingRecordOfCars() {
        return this.cars;
    }
}
