package racing;

import exception.CarLocationException;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {
    private Set<Car> carSet;

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

    public void startRace() throws CarLocationException {
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
    }

    public Set<Car> getWinCarList() {
        int winnerLocation = getMaxNumberOfList(carSet.stream().map(Car::getLocation).collect(Collectors.toList()));
        return carSet.stream().filter(car -> car.getLocation() == winnerLocation).collect(Collectors.toSet());
    }

    private int getMaxNumberOfList(List<Integer> numList) {
        return numList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
