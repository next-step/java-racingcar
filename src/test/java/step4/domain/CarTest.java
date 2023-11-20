package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("생성된 자동차는 이름을 가진다.")
    void carHasNameTest() {
        Car testCar = new Car("자바");

        Assertions.assertThat(testCar.name()).isEqualTo("자바");
    }
}
