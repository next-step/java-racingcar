package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @DisplayName("입력한 자동차 이름이 5자를 넘어갈 수 없다.")
    @Test
    void nameCheckTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car("poby123");
        });
    }


}
