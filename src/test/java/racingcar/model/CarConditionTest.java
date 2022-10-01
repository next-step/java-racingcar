package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarConditionTest {

    @Test
    @DisplayName("랜덤값이 4이상일때는 inspect()가 true를 출력한다.")
    void inspect_4() {
        CarCondition condition = new CarCondition() {
            @Override
            protected int random() {
                return 4;
            }
        };

        boolean actual = condition.inspect();

        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("랜덤값이 3이하일때는 inspect()가 false를 출력한다.")
    void inspect_3() {
        CarCondition condition = new CarCondition() {
            @Override
            protected int random() {
                return 3;
            }
        };

        boolean actual = condition.inspect();

        assertThat(actual).isFalse();
    }
}
