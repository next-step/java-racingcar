package step3and4.game.car;

import step3and4.client.number.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars carsWithTurnUsed() {
        List<Car> movedCars = cars.stream()
                .map(Car::movedCar)
                .collect(Collectors.toUnmodifiableList());
        return new Cars(movedCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars that = (Cars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public List<String> positionsAndNames() {
        return cars.stream().map(Car::print)
                .collect(Collectors.toUnmodifiableList());
    }

    public static class Factory {

        private final String[] carsNames;

        public Factory(String[] carsNames) {
            this.carsNames = carsNames;
        }

        public Cars cars(Number number) {
            verifyCarsName();

            List<Car> cars = Arrays.stream(carsNames)
                    .map(carName -> new Car.Factory(number, carName).car())
                    .collect(Collectors.toUnmodifiableList());

            return new Cars(cars);
        }

        private void verifyCarsName() {
            if (carsNames.length == 0) {
                throw new IllegalStateException("유효한 문자열이 아닙니다.");
            }

            Arrays.stream(carsNames).forEach(this::verifyCarName);
        }

        private void verifyCarName(String carName) {
            if (carName == null || carName.isEmpty() || carName.isBlank()) {
                throw new IllegalStateException("유효한 문자열이 아닙니다.");
            }
        }
    }
}
