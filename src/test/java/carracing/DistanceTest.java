package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {

    @Test
    @DisplayName("이동거리만큼 대쉬를 반환한다.")
    void distance_toDash(){
        assertThat(new Distance(3).toDash().length()).isEqualTo(3);
    }

    @Test
    @DisplayName("이동거리가 0일 경우 빈값을 반환 한다.")
    void distance_0_toDash(){
        assertThat(new Distance().toDash().length()).isEqualTo(0);
    }
}
