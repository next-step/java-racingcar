package step3.cars;

import step3.car.RacingCar;
import step3.number.RandomNumber;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars implements Cars {

    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    @Override
    public Cars carsWithTurnUsed() {
        List<RacingCar> movedCars = cars.stream()
                .map(RacingCar::movedCar)
                .collect(Collectors.toUnmodifiableList());
        return new RacingCars(movedCars);
    }

    @Override
    public void printPosition() {
        cars.forEach(RacingCar::printPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public static class Factory {

        private final int numberOfCars;

        public Factory(int numberOfCars) {
            this.numberOfCars = numberOfCars;
        }

        public Cars cars() {
            List<RacingCar> cars = IntStream.range(0, numberOfCars)
                    .boxed()
                    .map(number -> new RacingCar(new RandomNumber()))
                    .collect(Collectors.toUnmodifiableList());

            return new RacingCars(cars);
        }

    }

}
