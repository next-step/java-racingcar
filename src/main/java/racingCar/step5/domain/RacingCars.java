package racingCar.step5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCars {

    public static final String CAR_NAME_SEPERATOR = ",";

    private final List<RacingCar> cars;

    public RacingCars(final List<RacingCar> cars){
        this.cars = cars;
    }

    public static RacingCars ofNames(String names) {
        String[] namesArray = splitName(names);
        List<RacingCar> cars = new ArrayList<>();

        for (String carName : namesArray) {
            cars.add(RacingCar.ofName(carName));
        }
        return new RacingCars(cars);
    }

    public static RacingCars ofCars(List<RacingCar> cars) {
        return new RacingCars(cars);
    }

    private static String[] splitName(String names) {
        return names.split(CAR_NAME_SEPERATOR);
    }

    public int countCars() {
        return this.cars.size();
    }

    public void move(RandomNumber randomNumber) {
        for (RacingCar car : cars) {
            car.move(randomNumber.generate());
        }
    }

    public int maxPosition() {
        int maxPosition = 0;

        for (RacingCar car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<RacingCar> samePosition(int position) {
        List<RacingCar> samePositionCars = new ArrayList<>();
        for (RacingCar car : cars) {
            if(car.isSamePosition(position)) samePositionCars.add(car);
        }
        return samePositionCars;
    }

    public List<RacingCar> getCars() {
        return new ArrayList<RacingCar>(cars);
    }

    public RacingCars copy() {
        return new RacingCars(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars cars1 = (RacingCars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
}
