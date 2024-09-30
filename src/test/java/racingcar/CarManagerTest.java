package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CarManagerTest {


    @Test
    void 자동차생성_입력대수만큼() {
        int cntOfCar = 3;
        CarManager carManager = new CarManager();

        List<Car> carList = carManager.createCarsByCnt(cntOfCar);
        assertThat(carList.size()).isEqualTo(3);
    }

}
