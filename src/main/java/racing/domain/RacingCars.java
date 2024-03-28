package racing.domain;

import exception.CarLocationException;
import util.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {
    private final Set<Car> carSet;

    public RacingCars(String carNames) {
        String[] carNameArr = carNames.split(",");
        Set<Car> carSet = new TreeSet<>(Comparator.comparing(Car::getName));
        for (String carName : carNameArr) {
            carSet.add(new Car(carName, new Location(0)));
        }
        this.carSet = carSet;
    }

    public Set<RacingHistory> startRace(Count tryCount, RandomNumberGenerator randomNumberGenerator) throws CarLocationException {
        Set<RacingHistory> racingHistory = new TreeSet<>(Comparator.comparing(RacingHistory::getRound));
        for (int i = 0; i < tryCount.getValue(); i++) {
            Set<Car> updatedCarSet = racing(randomNumberGenerator);
            racingHistory.add(new RacingHistory(i + 1, updatedCarSet));
        }
        return racingHistory;
    }

    private Set<Car> racing(RandomNumberGenerator randomNumberGenerator) throws CarLocationException {
        Iterator<Car> iterator = carSet.iterator();
        Set<Car> updatedCarSet = new TreeSet<>(Comparator.comparing(Car::getName));
        while (iterator.hasNext()) {
            Car nextCar = iterator.next();
            Integer randomNumber = randomNumberGenerator.getRandomNumber();
            Location newCarLocation = nextCar.moveForward(randomNumber);
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
                .filter(car -> car.isSameLocation(winnerLocation))
                .collect(Collectors.toSet());
    }

    private int getMaxNumberOfList(List<Integer> numList) {
        return numList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
