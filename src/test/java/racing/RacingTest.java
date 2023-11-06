package racing;

import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.Car;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {
    @DisplayName("입력받은 자동차 이릅 배열로 자동차 이름을 생성한다.")
    @Test
    void ready() {
        // given
        Racing racing = new Racing();
        String inputNames = "test1,test2,test3";
        String[] carNames = inputNames.split(",");

        // when
        List<Car> participatingCars = racing.ready(carNames);

        // then
        assertThat(participatingCars.size()).isEqualTo(carNames.length);
        for (int i = 0; i < carNames.length; ++i) {
            assertThat(participatingCars.get(i).name()).isEqualTo(carNames[i]);
        }
    }
}
