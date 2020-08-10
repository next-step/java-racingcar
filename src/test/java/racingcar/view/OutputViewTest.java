package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.view.OutputView.*;

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
    void 가장높은_상태값_출력_성공() {
        cars.get(1).setStatus(5);
        assertEquals(5, getWinnerStatus(cars));
    }

    @Test
    void 우승자_출력_성공() {
        cars.get(0).setStatus(4);
        cars.get(1).setStatus(5);
        cars.get(2).setStatus(5);
        printRacingWinner(cars, 5);
    }

    @Test
    void 실행_결과출력_성공() {
        resultView(cars, 5);
    }
}