package carracing.model;

import carracing.util.ExceptionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String DELIMITER = ",";

    private static Integer tryTotalCount = 0;

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String name) {
        List<String> names = getSplitName(name);
        return new Cars(getCarList(names));
    }

    private static List<String> getSplitName(String name) {
        List<String> names = Arrays.asList(name.split(DELIMITER));
        return names;
    }

    private static List<Car> getCarList(List<String> names) {
        return names.stream()
            .map(carName -> Car.from(carName))
            .collect(Collectors
                .toCollection(ArrayList::new)
            );
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
