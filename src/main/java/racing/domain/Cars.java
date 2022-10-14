package racing.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public static final String CAR_NAME_REGEX = ",";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Stream<Car> getCarStream() {
        return cars.stream();
    }

    public Cars getWinners() {
        int winnerScore = cars.stream()
                .map(Car::getDistance)
                .mapToInt(Distance::getDistance)
                .max().getAsInt();
        return getCarsWithSameDistance(winnerScore);
    }

    public Cars getCarsWithSameDistance(int distance) {
        List<Car> result = this.getCarStream()
                .filter(car -> car.isSameDistance(distance))
                .collect(Collectors.toList());
        return new Cars(result);
    }

    public static Cars makeCars(Car... cars) {
        return new Cars(Arrays.asList(cars));
    }

    public static Cars makeCars(String carNamesFromClient) {
        String[] carNames = carNamesFromClient.split(CAR_NAME_REGEX);
        return makeCars(carNames);
    }

    public static Cars makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(new CarName(carName)));
        }
        return new Cars(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cars))
            return false;

        ListIterator<Car> e1 = cars.listIterator();
        ListIterator<?> e2 = ((Cars) o).cars.listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            Car o1 = e1.next();
            Car o2 = (Car) e2.next();
            if (!(Objects.equals(o1, o2)))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
