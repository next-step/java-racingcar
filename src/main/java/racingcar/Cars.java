package racingcar;

import racingcar.pattern.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String names) {
        String[] carNames = names.split(",");
        List<Car> cars = new ArrayList<>();
        for (int number = 0; number < carNames.length; number++) {
            cars.add(new Car(carNames[number]));
        }
        return new Cars(cars);
    }

    public void play(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.play(numberGenerator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners(int maxPosition) {
        return getCars().stream().filter(car -> car.isWinner(maxPosition)).collect(Collectors.toList());
    }
}
