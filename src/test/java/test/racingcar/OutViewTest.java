package test.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.OutView;

import java.util.List;

public class OutViewTest {

    @Test
    @DisplayName("화면에 찍히는 = 개수 확인")
    void printTest() {
        List<Car> cars = List.of(new Car(2), new Car(4), new Car(5));
        new OutView().printResult(cars);
    }
}
