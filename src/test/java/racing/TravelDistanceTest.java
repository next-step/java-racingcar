package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TravelDistanceTest {

    @DisplayName(value = "이동거리는 0 보다 작을 수 없다.")
    @Test
    void moveException() {

        // when
        assertThatThrownBy(() -> {
            new TravelDistance(-1);
        // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "한칸 이동거리 테스트")
    @Test
    void move() {
        // given
        TravelDistance travelDistance;

        // when
        travelDistance = new TravelDistance().move();

        // then
        assertThat(travelDistance).isEqualTo(new TravelDistance(1));
    }
}