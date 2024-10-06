package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Garage {

    private static final String DELIMITER = ",";
    private final List<Car> cars;

    private Garage(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("차는 최소 1대 이상 필요 합니다.");
        }

        validateUniqueCarName(cars);

        this.cars = new ArrayList<>(cars);
    }

    public static Garage createCars(String names) {

        ArrayList<Car> cars = new ArrayList<>();

        String[] carNames = names.split(DELIMITER);

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return new Garage(cars);
    }

    private static void validateUniqueCarName(List<Car> cars) {
        Set<String> names = new HashSet<>();

        for (Car car : cars) {
            String name = car.getName();
            if (!names.add(name)) {
                throw new IllegalArgumentException("차 이름 \"" + name + "\"이 중복되었습니다.");
            }
        }
    }


    public List<Car> getCars() {
        return cars;
    }
}
