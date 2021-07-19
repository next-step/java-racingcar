package racingcar;

import java.util.ArrayList;

class RacingCars {
    private static final String MOVEMENT_SITUATION = "-";

    private ArrayList<String> cars;

    private RacingCars(ArrayList<String> cars) {
        this.cars = cars;
    }

    public static RacingCars from(ArrayList<String> cars) {
        return new RacingCars(cars);
    }

    public int size() {
        return this.cars.size();
    }

    public void goForward(final int index, final int randomNumber) {
        if (isNumberMoreThanFour(randomNumber)) {
            String car = this.cars.get(index);
            String newCar = car + MOVEMENT_SITUATION;
            this.cars.set(index, newCar);
        }
    }

    public String get(final int index) {
        return this.cars.get(index);
    }

    private boolean isNumberMoreThanFour(final int number) {
        return number >= 4;
    }
}
