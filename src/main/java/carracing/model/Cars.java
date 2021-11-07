package carracing.model;

import carracing.util.ExceptionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private static final Integer START_INDEX = 0;

    private static Integer tryTotalCount = 0;

    private List<Car> cars;

    public Cars(Integer carCount) {
        cars = IntStream.range(START_INDEX, carCount)
            .mapToObj((idx) -> new Car(idx))
            .collect(Collectors
                .toCollection(ArrayList::new));
    }

    public Integer getSize() {
        return cars.size();
    }

    public void carsRace() {
        for (Car car : cars) {
            car.runRace();
        }
        tryTotalCount++;
    }

    public Car getCar(Integer idx) {
        try {
            return cars.get(idx);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException(ExceptionUtils.CARS_INDEX_OUT_BOUND_EXCEPTION);
        }
    }

    public Integer getTryTotalCount() {
        return this.tryTotalCount;
    }

}
