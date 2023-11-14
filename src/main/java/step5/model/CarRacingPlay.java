package step5.model;

import step5.controller.ChampionCarsDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingPlay {

    private final List<Car> cars = new ArrayList<>();

    private final RandomValueGenerator randomValueGenerator;

    public CarRacingPlay(RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }



    public void makeRacingCars(List<String> carNamesList) {
        carNamesList.forEach(carName -> cars.add(Car.makeCar(carName)));
    }

    public List<Car> raceOneCycle() {

        if (cars.isEmpty()) {
            throw new RuntimeException("먼저 경주에 참여할 자동차를 정의해야 합니다.");
        }

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
}
