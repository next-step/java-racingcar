package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarOldTest {

    @DisplayName("Car 최초 생성 시 위치 0에서 출발 확인")
    @Test
    public void assertCarInitPositionIsZero() {
        assertThat(new Car_old().getPosition()).isEqualTo(0);
    }
    /**
     * Mocking Test (random 추상화) : PositionTest으로 이관
     */

}
