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

    public List<RaceStatus> start() {
        return doRace(participatedCarList());
    }

    private List<Car> participatedCarList() {
        List<Car> participatedCarList = new ArrayList<>();

        for (int i = 0; i < numberOfCars.numberOfCars(); i++) {
            participatedCarList.add(new Car(new RandomStrategy()));
        }

        return participatedCarList;
    }

    private List<RaceStatus> doRace(List<Car> carList) {
        List<RaceStatus> raceStatusList = new ArrayList<>();

        for (int i = 0; i < numberOfAttempts.numberOfAttempts(); i++) {
            boolean isLastAttempt = numberOfAttempts.isSame(i + 1);
            carList.forEach(Car::move);
            raceStatusList.add(raceStatus(carList, isLastAttempt));
        }

        return raceStatusList;
    }

    private RaceStatus raceStatus(List<Car> carList, boolean isLastAttempt) {
        List<Integer> positionOfCarList = carList.stream()
                .map(Car::position)
                .collect(Collectors.toList());

        return new RaceStatus(positionOfCarList, isLastAttempt);
    }
}
