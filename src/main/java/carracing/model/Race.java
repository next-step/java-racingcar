package carracing.model;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<NameOfCar> nameOfCarList;
    private final NumberOfAttempts numberOfAttempts;


    public Race(List<NameOfCar> nameOfCarList, NumberOfAttempts numberOfAttempts) {
        this.nameOfCarList = nameOfCarList;
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<RaceResultOfCar> start() {
        return doRace(participatedCarList());
    }

    private List<Car> participatedCarList() {
        return nameOfCarList.stream()
                .map(Car::newCar)
                .collect(Collectors.toList());
    }

    private List<RaceResultOfCar> doRace(List<Car> carList) {
        for (int i = 0; i < numberOfAttempts.numberOfAttempts(); i++) {
            carList.forEach(car -> car.move(new RandomStrategy()));
        }

        return carList.stream()
                .map(Car::raceResult)
                .collect(Collectors.toList());
    }
}
