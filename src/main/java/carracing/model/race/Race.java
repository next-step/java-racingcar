package carracing.model.race;

import carracing.model.NameOfCar;
import carracing.model.NumberOfAttempts;
import carracing.model.car.Car;
import carracing.model.car.RaceRecordOfCar;
import carracing.model.car.strategy.RandomStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<NameOfCar> nameOfCarList;
    private final NumberOfAttempts numberOfAttempts;

    private Race(List<NameOfCar> nameOfCarList, NumberOfAttempts numberOfAttempts) {
        this.nameOfCarList = nameOfCarList;
        this.numberOfAttempts = numberOfAttempts;
    }

    public static Race newRace(final List<NameOfCar> nameOfCarList, final NumberOfAttempts numberOfAttempts) {
        return new Race(nameOfCarList, numberOfAttempts);
    }

    public RaceResult start() {
        return doRace(participatedCarList());
    }

    private List<Car> participatedCarList() {
        return nameOfCarList.stream()
                .map(Car::newCar)
                .collect(Collectors.toList());
    }

    private RaceResult doRace(final List<Car> carList) {
        for (int i = 0; i < numberOfAttempts.numberOfAttempts(); i++) {
            carList.forEach(car -> car.move(new RandomStrategy()));
        }

        List<RaceRecordOfCar> recordOfCarList = carList.stream()
                .map(Car::raceRecord)
                .collect(Collectors.toList());

        return RaceResult.newResult(recordOfCarList);
    }
}
