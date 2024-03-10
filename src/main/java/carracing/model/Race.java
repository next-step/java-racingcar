package carracing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final NumberOfCars numberOfCars;
    private final NumberOfAttempts numberOfAttempts;


    public Race(NumberOfCars numberOfCars, NumberOfAttempts numberOfAttempts) {
        this.numberOfCars = numberOfCars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<RaceRecord> start() {
        return doRace(participatedCarList());
    }

    private List<Car> participatedCarList() {
        List<Car> participatedCarList = new ArrayList<>();

        for (int i = 0; i < numberOfCars.numberOfCars(); i++) {
            participatedCarList.add(new Car());
        }

        return participatedCarList;
    }

    private List<RaceRecord> doRace(List<Car> carList) {
        List<RaceRecord> raceRecordList = new ArrayList<>();

        for (int i = 0; i < numberOfAttempts.numberOfAttempts(); i++) {
            boolean isLastAttempt = numberOfAttempts.isSame(i + 1);
            carList.forEach(car -> car.move(new RandomStrategy()));
            raceRecordList.add(raceStatus(carList, isLastAttempt));
        }

        return raceRecordList;
    }

    private RaceRecord raceStatus(List<Car> carList, boolean isLastAttempt) {
        List<Integer> positionOfCarList = carList.stream()
                .map(Car::position)
                .collect(Collectors.toList());

        return new RaceRecord(positionOfCarList, isLastAttempt);
    }
}
