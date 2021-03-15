package new_racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {

    @Test
    @DisplayName("이동거리 증 테스트")
    public void rou() throws Exception {
        //given
        Distance beforeDistance = new Distance();

        //when
        Distance afterDistance = beforeDistance.addDistance();

        //then
        assertThat(afterDistance.getDistance()).isEqualTo(1);
    }
}
