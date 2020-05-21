package step4.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {

    public static List<Car> createCars(String[] names) {

        validNamesCheck(names);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.of(name));
        }
        return cars;
    }

    private static void validNamesCheck(String[] names) {
        if (names == null || names.length <= 0) {
            throw new IllegalArgumentException("차량 이름 목록이 null 이거나 비어있습니다.");
        }

        Arrays.stream(names)
                .forEach(name -> {
                    if (name == null || name.replaceAll(" ", "").isEmpty()) {
                        throw new IllegalArgumentException("차량 이름이 유효하지 않습니다. " + name);
                    }
                });
    }
}
