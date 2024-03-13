package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Distance;
import racingcar.exception.NegativeInitialDistanceException;

import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {

    @Test
    @DisplayName("[성공] Distance 생성 시 별도의 초기값을 전달하지 않으면 거리는 0이다.")
    void Distance_기본_생성자() {
        assertThat((new Distance()).get()).isZero();
    }

    @Test
    @DisplayName("[성공] Distance 생성 시 별도의 초기값 3을 전달하면 거리는 3이다.")
    void Distance_초기값_전달_생성자() {
        assertThat((new Distance(3)).get()).isEqualTo(3);
    }

    @Test
    @DisplayName("[실패] Distance 생성 시 별도의 음수를 전달하면 Distance")
    void Distance_초기값_음수_예외() {
        int initValue = -1;
        assertThatThrownBy(() -> {
            new Distance(initValue);
        }).isInstanceOf(NegativeInitialDistanceException.class)
                .hasMessage(MessageFormat.format("거리의 초기값으로 음수는 설정할 수 없습니다. (입력된 값: {0})", initValue));
    }
}
