package racingcar.domain;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CarManagerTest {


    @Test
    void 자동차생성_입력자동차이름만큼() {
        List<String> namesOfCar = Arrays.asList("car1", "car2", "car3");
        CarManager carManager = new CarManager();

        List<Car> carList = carManager.createCarsByCnt(namesOfCar);
        assertThat(carList.size()).isEqualTo(3);
    }

}
