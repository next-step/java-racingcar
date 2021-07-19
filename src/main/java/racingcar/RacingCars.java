package racingcar;

import java.util.ArrayList;

class RacingCars {
    private ArrayList<String> cars;

    private static final String MOVEMENT_SITUATION = "-";

    private RacingCars(ArrayList<String> cars) {
        this.cars = cars;
    }

    static RacingCars from(ArrayList<String> cars) {
        return new RacingCars(cars);
    }

    int size() {
        return this.cars.size();
    }

    void goForward(final int index, final int randomNumber) {
        if (isNumberMoreThanFour(randomNumber)) {
            String car = this.cars.get(index);
            String newCar = car + MOVEMENT_SITUATION;
            this.cars.set(index, newCar);
        }
    }

    String get(final int index) {
        return this.cars.get(index);
    }

    private boolean isNumberMoreThanFour(final int number) {
        return number >= 4;
    }
}
