package carrace.domain;

import java.util.*;

public class RaceTrack {
    private static final int START_POSITION = 1;
    private final List<Car> carList = new ArrayList<>();
    private final RacingRule racingRule;

    public RaceTrack(RacingRule racingRule, int carCount) {
        this.racingRule = racingRule;
        this.carList.addAll(CarFactory.makeCars(carCount));
    }

    public RaceTrack(RacingRule racingRule, String[] carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException();
        }
        this.racingRule = racingRule;
        for (String carName : carNames) {
            carList.add(new Car(START_POSITION, carName));
        }
    }

    public RaceTrack(RacingRule racingRule, Car... cars) {
        this.racingRule = racingRule;
        carList.addAll(Arrays.asList(cars));
    }

    public void next() {
        for (Car car : carList) {
            car.tryToMoveForward(racingRule);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinner() {
        List<Car> sortedList = new ArrayList<>(carList);
        sortedList.sort(new CarPositionComparator());

        List<Car> winners = new ArrayList<>();

        Car fistIndexCar = sortedList.get(0);
        winners.add(fistIndexCar);

        for (Car car : sortedList.subList(1, sortedList.size())) {
            if(fistIndexCar.getPosition() == car.getPosition()) {
                winners.add(car);
            }
        }

        return winners;
    }

    private static class CarPositionComparator implements Comparator<Car> {

        @Override
        public int compare(Car car1, Car car2) {
            if(car1.getPosition() < car2.getPosition()) {
                return 1;
            } else if (car1.getPosition() == car2.getPosition()) {
                return 0;
            }
            return -1;
        }
    }
}
