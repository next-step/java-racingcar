package racingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingCar.domain.Distance;

public class DistanceTest {
    private static final int NEGATIVE_NUMBER = -1;

    @Test
    @DisplayName("Distance class는 음수가 될 수 없으면, IllegalArgumentException 에러를 반환한다.")
    void test1() {
        assertThatThrownBy(() -> new Distance(NEGATIVE_NUMBER)).isInstanceOf(IllegalArgumentException.class);
    }
}
