package racing;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Racing {
    private final int attemptsCount;
    private final int carCount;
    private final List<Car> cars = new ArrayList<>();

    public Racing(int carCount, int attemptsCount) {
        this.carCount = carCount;
        this.attemptsCount = attemptsCount;
        participateCars();
    }

    private void participateCars() {
        for (int i = 0; i < carCount; i++) {
            joinCar();
        }
    }

    private void joinCar() {
        cars.add(new Car());
    }

    public void StartRacing() {
        IntStream.range(0, attemptsCount).forEach(i -> moveCars());
    }

    private void moveCars() {
        cars.forEach(car -> car.moveCar(getValueForMove()));
    }

    private int getValueForMove() {
        return new Random().nextInt(10);
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCarCount() {
        return carCount;
    }
}
