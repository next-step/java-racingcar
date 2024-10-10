package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"car1", "car2", "car3"})
    @DisplayName("생성하면 차 이름을 가지고 있습니다.")
    public void getCarNameTest(String carName) {
        CarName carNameInstance = CarName.valueOf(carName);
        assertThat(carNameInstance.value()).isEqualTo(carName);
    }

    @Test
    @DisplayName("다섯 글자를 넘어가는 차 이름을 생성 시도 시, 에러가 발생합니다")
    public void tooLongCarNameTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> CarName.valueOf("1234567"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1", "car2", "car3"})
    @DisplayName("같은 이름을 가지면 equals()가 true다")
    public void equalsTest(String carName) {
        CarName carNameInstance1 = CarName.valueOf(carName);
        CarName carNameInstance2 = CarName.valueOf(carName);
        assertThat(carNameInstance1).isEqualTo(carNameInstance2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1", "car2", "car3"})
    @DisplayName("같은 이름을 가지면 같은 hashCode()가 true다")
    public void hashCodeTest(String carName) {
        CarName carNameInstance1 = CarName.valueOf(carName);
        CarName carNameInstance2 = CarName.valueOf(carName);
        assertThat(carNameInstance1.hashCode()).isEqualTo(carNameInstance2.hashCode());
    }
}
