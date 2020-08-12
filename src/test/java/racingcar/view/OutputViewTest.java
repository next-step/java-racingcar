package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.OutputView.printCarStatus;
import static racingcar.view.OutputView.resultView;

class OutputViewTest {
    Cars cars;

    @BeforeEach
    void init() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("애플", 4));
        carList.add(new Car("삼성", 5));
        carList.add(new Car("구글", 3));
        cars = new Cars(carList);
    }

    @Test
    void 임의_레이싱_상태출력_성공() {
        printCarStatus(cars);
    }

    @Test
    void 실행_결과출력_성공() {
        resultView(cars);
    }
}