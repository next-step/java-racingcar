package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNoTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("생성하면 입력한 차 번호를 가지고 있습니다.")
    public void getCarNoTest(int carNo) {
        CarNo carNoInstance = CarNo.valueOf(carNo);
        assertThat(carNoInstance.value()).isEqualTo(carNo);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("같은 번호를 가지면 equals()가 true다")
    public void equalsTest(int carNo) {
        CarNo carNoInstance1 = CarNo.valueOf(carNo);
        CarNo carNoInstance2 = CarNo.valueOf(carNo);
        assertThat(carNoInstance1).isEqualTo(carNoInstance2);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("같은 번호를 가지면 같은 hashCode()가 true다")
    public void hashCodeTest(int carNo) {
        CarNo carNoInstance1 = CarNo.valueOf(carNo);
        CarNo carNoInstance2 = CarNo.valueOf(carNo);
        assertThat(carNoInstance1.hashCode()).isEqualTo(carNoInstance2.hashCode());
    }
}
