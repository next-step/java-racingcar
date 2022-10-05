package nextstep.javaracingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DistanceTest {

    @DisplayName("거리는 음수가 허용되지 않는다.")
    @Test
    public void spec01() {

        assertThatThrownBy(() -> new Distance(-1)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Distance(-2)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("거리는 0 이상일 수 있다.")
    @Test
    public void spec02() {
        assertThat(new Distance(0)).isNotNull();
        assertThat(new Distance(3)).isNotNull();
    }

    @DisplayName("거리는 특정 거리 만큼 증가할 수 있다.")
    @Test
    public void spec03() {
        final Distance distance = new Distance(3);
        assertThat(distance.plus(new Distance(1))).isEqualTo(new Distance(4));
    }

    @DisplayName("거리는 순회 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 7})
    public void spec04(final int value) {
        final Distance distance = new Distance(value);
        final List<Integer> counter = new ArrayList<>();
        for (Integer index : distance) {
            counter.add(index);
        }

        assertThat(counter).hasSize(value);
    }

}
