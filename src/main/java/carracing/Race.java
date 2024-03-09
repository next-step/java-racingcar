package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private int numberOfCars;
    private int numberOfAttempts;

    public Race(int numberOfCars, int numberOfAttempts) {
        this.numberOfCars = numberOfCars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<RaceStatus> start() {
        return doRace(participatedCarList());
    }

    private List<Car> participatedCarList() {
        List<Car> participatedCarList = new ArrayList<>();

        for(int i = 0; i < numberOfCars; i++) {
            participatedCarList.add(new Car(new RandomStrategy()));
        }

        return participatedCarList;
    }

    private List<RaceStatus> doRace(List<Car> carList) {
        List<RaceStatus> raceStatusList = new ArrayList<>();

        for(int i = 0; i < numberOfAttempts; i++) {
            boolean isLastAttempt = i == (numberOfAttempts - 1);
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
