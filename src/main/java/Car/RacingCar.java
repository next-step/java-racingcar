package Car;

import java.util.*;

public class RacingCar {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final Random random = new Random();

    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public RacingCar(int carCount) {
        validate(carCount);

        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void gameStart() {
        cars.stream()
                .forEach(car -> car.move(random.nextInt(RANDOM_NUMBER_BOUND)));
    }

    private void validate(int carCount) {
        if (carCount <= 0) {
            throw new IllegalArgumentException("0보다 큰 값을 입력해주세요.");
        }
    }
}
