import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName(value = "자동차 일급 컬렉션 테스트")
class CarsTest {
    Cars cars = new Cars();
    Car car;

    @ParameterizedTest
    @ValueSource(strings = {"바나나차차", "딸기차차", "토마토차차", ""})
    void addCar(String name) {
        car = new Car(name);
        cars.addCar(car);
        assertTrue(cars.hasCar(car));
    }

    
}