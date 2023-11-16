package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.car.Distance;

public class Step5DistanceTest {

    @Test
    @DisplayName("Distance object 생성 테스트")
    public void distance_object() {
        // given
        Distance distance = Distance.one();

        // then
        Assertions.assertThat(distance)
                  .extracting("distance")
                  .isEqualTo(1);
    }
}
