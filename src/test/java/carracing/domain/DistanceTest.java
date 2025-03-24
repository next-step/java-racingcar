package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {
    @DisplayName("Distance의 hasSameValue 메소드 테스트")
    @Test
    void test_has_same_value() {
        Distance distance = new Distance(3);
        assertThat(distance.hasSameValue(3)).isTrue();
    }

    @DisplayName("Distance의 max value 찾는 메소드 테스트")
    @Test
    void find_max_value() {
        Distance distance = new Distance(3);
        assertThat(distance.returnMaxValue(4)).isEqualTo(4);
    }
}
