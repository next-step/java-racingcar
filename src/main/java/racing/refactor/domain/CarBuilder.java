package racing.refactor.domain;

import racing.refactor.view.CarDto.Request;
import racing.refactor.view.CarDto.Response;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class CarBuilder {

    public static List<Car> toCar(Request.GameCreation creation) {
        List<String> names = creation.getCarNames();
        return names.stream()
                .map(Car::new)
                .limit(names.size())
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public static List<Response.CarInformation> toCarInformation(Cars cars) {
        return cars.toList()
                .stream()
                .map(car -> new Response.CarInformation(
                         car.getName()
                                .getValue()
                        ,car.getPosition()
                                .getValue()
                        )
                )
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }
}
