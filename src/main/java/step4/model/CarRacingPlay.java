package step4.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRacingPlay {

    private final List<Car> cars = new ArrayList<>();

    private final RandomValueGenerator randomValueGenerator;

    public CarRacingPlay(RandomValueGenerator randomValueGenerator, List<String> attendCarNames) {
        this.randomValueGenerator = randomValueGenerator;
        initializeRacingCars(attendCarNames);
    }

    public List<Car> raceOneCycle() {
        for (Car car : cars) {
            int randomValue = randomValueGenerator.generateRandomValue();
            car.go(randomValue);
        }
        return cars;
    }

    public ChampionCarsDto findChampions() {
        Car maxCar = cars.stream()
                .max(Comparator.comparingInt(Car::getDistance)).get();

        List<Car> carList = cars.stream().filter(car -> car.getDistance() == maxCar.getDistance())
                .collect(Collectors.toList());

        return new ChampionCarsDto(carList);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void initializeRacingCars(List<String> attendCarNames) {
        attendCarNames.forEach(carName -> cars.add(Car.makeCar(carName)));
    }

}
