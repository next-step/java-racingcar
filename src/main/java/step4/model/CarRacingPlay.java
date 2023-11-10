package step4.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingPlay {

    private final List<Car> cars = new ArrayList<>();

    private final RandomValueGenerator randomValueGenerator;

    public CarRacingPlay(RandomValueGenerator randomValueGenerator, String inputCarNames) {
        this.randomValueGenerator = randomValueGenerator;
        initializeRacingCars(extractCarNames(inputCarNames));
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

    private List<String> extractCarNames(String carNames) {
        String[] carNameArray = carNames.split(",");

        for (String carName : carNameArray) {
            checkCarNameLength(carName);
        }

        return List.of(carNameArray);
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new RuntimeException("자동차 이름은 5글자를 초과하면 안됩니다.");
        }
    }

}
