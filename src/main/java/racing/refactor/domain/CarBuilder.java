package racing.refactor.domain;

import racing.refactor.dto.RequestGameCreation;
import racing.refactor.dto.ResponseCar;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class CarBuilder {

    public static List<Car> toCar(RequestGameCreation creation) {
        List<String> names = creation.getCarNames();
        return names.stream()
                .map(Car::new)
                .limit(names.size())
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public static List<ResponseCar> toCarInformation(List<Car> cars) {
        return cars.stream()
                .map(car -> new ResponseCar(
                         car.getName()
                                .getValue()
                        ,car.getPosition()
                                .getValue()
                        )
                )
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }
}
