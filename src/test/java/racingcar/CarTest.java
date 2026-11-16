package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차의 최초 전진 상태는 0 이다.")
    @Test
    public void test_1() {
        assertThat(new Car().getPosition()).isEqualTo(0);
    }

}