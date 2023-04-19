package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private final static Random random = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    final List<Car> values;

    public Cars(int numberOfCars) {
        values = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            values.add(new Car());
        }
    }

    public Cars(String[] carNames) {
        values = new ArrayList<>();
        for (String carName : carNames) {
            values.add(new Car(carName));
        }
    }

    public void move() {
        values.stream()
                .forEach(car ->
                        car.move(randomNumber())
                );
    }

    public List<String> winners() {
        int highScore = highScore();
        return values.stream()
                .filter(car -> car.sameScore(highScore))
                .map(Car::name)
                .collect(Collectors.toList());
    }

    private int highScore() {
        return values.stream()
                .mapToInt(Car::location)
                .max()
                .orElseThrow(() -> new RuntimeException("점수를 계산할 수 없습니다."));
    }

    private int randomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public List<Car> cars() {
        return values;
    }
}
