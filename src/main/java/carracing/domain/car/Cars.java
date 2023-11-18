package carracing.domain.car;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        checkCarsSizeIsValid(cars);
        this.cars = cars;
    }

    private void checkCarsSizeIsValid(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 합니다");
        }
    }

    public void printMovingResult() {
        for (Car car : cars) {
            String result = "-".repeat(Math.max(0, car.movingDistance()));
            System.out.println(car.name() + " : " + result);
        }
    }

    public void printWinners() {
        StringBuilder sb = new StringBuilder();
        for (Car winner : cars) {
            sb.append(winner.name()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars inputCars = (Cars) o;
        return Objects.equals(cars, inputCars.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public Iterator<Car> iterator() {
        return this.cars.iterator();
    }
}
