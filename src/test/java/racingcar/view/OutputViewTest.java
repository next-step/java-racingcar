package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.OutputView.printCarStatus;
import static racingcar.view.OutputView.resultView;

class OutputViewTest {
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void init() {
        cars.add(new Car("애플", 1));
        cars.add(new Car("삼성", 1));
        cars.add(new Car("구글", 1));
    }

    @Test
    void 임의_레이싱_상태출력_성공() {
        printCarStatus(cars);
    }

    @Test
    void 실행_결과출력_성공() {
        resultView(cars, 5);
    }
}