package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("CarName 생성자 테스트")
    public void constructor() {
        assertThat(new Car("aaa")).isEqualTo(new Car("aaa"));
    }
}
