package racing.winner.domain;

import racing.winner.resolver.CarDto.Request;
import racing.winner.resolver.CarDto.Response;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Response.CarInformation> toCarInformation(List<Car> cars) {
        return cars.stream()
                .map(car -> new Response.CarInformation(
                         car.getName()
                        ,car.getDrivingDistance())
                )
                .collect(Collectors.toList());
    }
}
