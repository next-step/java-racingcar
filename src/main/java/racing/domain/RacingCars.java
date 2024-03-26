package racing.domain;

import exception.CarLocationException;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {
    private final Set<Car> carSet;
    private final Set<RacingHistory> racingHistory = new TreeSet<>(Comparator.comparing(RacingHistory::getRound));

    public RacingCars(String carNames) {
        String[] carNameArr = carNames.split(",");
        Set<Car> carSet = new TreeSet<>(Comparator.comparing(Car::getName));
        for (String carName : carNameArr) {
            carSet.add(new Car(carName, new Location(0)));
        }
        this.carSet = carSet;
    }

    public Set<Car> getCarSet() {
        return this.carSet;
    }

    public Set<RacingHistory> startRace(Count tryCount) throws CarLocationException {
        for (int i = 0; i < tryCount.getValue(); i++) {
            Set<Car> updatedCarSet = racing();
            racingHistory.add(new RacingHistory(i + 1, updatedCarSet));
        }
        return racingHistory;
    }

    private Set<Car> racing() throws CarLocationException {
        Iterator<Car> iterator = carSet.iterator();
        Set<Car> updatedCarSet = new TreeSet<>(Comparator.comparing(Car::getName));
        while (iterator.hasNext()) {
            Car nextCar = iterator.next();
            Location newCarLocation = nextCar.moveForward();
            String carName = nextCar.getName();
            updatedCarSet.add(new Car(carName, newCarLocation));
        }
        carSet.clear();
        carSet.addAll(updatedCarSet);
        return updatedCarSet;
    }

    public Set<Car> getWinCarList() {
        int winnerLocation = getMaxNumberOfList(carSet.stream().map(Car::getLocation).collect(Collectors.toList()));
        return carSet.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .collect(Collectors.toSet());
    }

    private int getMaxNumberOfList(List<Integer> numList) {
        return numList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
