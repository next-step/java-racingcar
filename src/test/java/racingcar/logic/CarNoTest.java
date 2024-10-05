package racingcar.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNoTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("생성하면 입력한 차 번호를 가지고 있습니다.")
    public void getCarNoTest(int carNo) {
        CarNo carNoInstance = CarNo.valueOf(carNo);
        Assertions.assertEquals(carNo, carNoInstance.getCarNo());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("같은 번호를 가지면 equals()가 true다")
    public void equalsTest(int carNo) {
        CarNo carNoInstance1 = CarNo.valueOf(carNo);
        CarNo carNoInstance2 = CarNo.valueOf(carNo);
        Assertions.assertEquals(carNoInstance1, carNoInstance2);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("같은 번호를 가지면 같은 hashCode()가 true다")
    public void hashCodeTest(int carNo) {
        CarNo carNoInstance1 = CarNo.valueOf(carNo);
        CarNo carNoInstance2 = CarNo.valueOf(carNo);
        Assertions.assertEquals(carNoInstance1.hashCode(), carNoInstance2.hashCode());
    }
}
