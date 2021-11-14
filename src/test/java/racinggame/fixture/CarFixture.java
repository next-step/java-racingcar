package racinggame.fixture;

import racinggame.domain.Car;
import racinggame.domain.value.Name;
import racinggame.domain.value.Position;

import java.util.Arrays;
import java.util.List;

public class CarFixture {
    public static final String CAR_NAME1 = "poby";
    public static final String CAR_NAME2 = "cron";
    public static final String CAR_NAME3 = "honu";
    public static final String CAR_NAME4 = "bung";

    public static final Car CAR1 = new Car(Name.of(CAR_NAME1), Position.createInitPosition());
    public static final Car CAR2 = new Car(Name.of(CAR_NAME2), Position.of(3));
    public static final Car CAR3 = new Car(Name.of(CAR_NAME3), Position.of(5));
    public static final Car CAR4 = new Car(Name.of(CAR_NAME4), Position.of(8));

    public static final List<Car> CARS = Arrays.asList(CAR1, CAR2, CAR3, CAR4);
}
