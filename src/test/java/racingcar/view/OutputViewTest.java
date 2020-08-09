package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.OutputView.printCarStatus;

class OutputViewTest {
    @Test
    void 임의_레이싱_상태출력_성공() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(3));
        cars.add(new Car(5));
        cars.add(new Car(4));
        printCarStatus(cars);
    }
}