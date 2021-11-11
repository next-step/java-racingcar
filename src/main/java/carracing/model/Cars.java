package carracing.model;

import carracing.exception.HistoryNullPointerException;
import carracing.model.run.RandomRunStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String DELIMITER = ",";
    private static final String CAR_INDEX_OUT_BOUND_EXCEPTION = "존재하지 않는 자동차 입니다.";

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
            car.runRace(new RandomRunStrategy());
        }
        tryTotalCount++;
    }

    public Car getCar(Integer idx) {
        try {
            return cars.get(idx);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException(CAR_INDEX_OUT_BOUND_EXCEPTION);
        }
    }

    public Integer getTryTotalCount() {
        return this.tryTotalCount;
    }

    public List<String> getWinners() {
        Long max = this.getSuccessMaxCount();

        return cars.stream()
            .filter(car -> car.getSuccessCount().equals(max))
            .map(Car::getName)
            .collect(Collectors
                .toCollection(ArrayList::new)
            );
    }

    private Long getSuccessMaxCount() {
        return cars.stream()
            .mapToLong(Car::getSuccessCount)
            .max()
            .orElseThrow(HistoryNullPointerException::new);
    }

}
