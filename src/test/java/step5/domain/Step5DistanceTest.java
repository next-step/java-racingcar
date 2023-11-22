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

    @Test
    @DisplayName("거리 한번 증가 테스트")
    void distance_plus_one() {
        Distance distance = Distance.one();


        Distance newDistance = distance.addOne();


        Assertions.assertThat(newDistance.fartherThan(distance)).isTrue();
    }

    @Test
    @DisplayName("거리 지정 숫자 증가 테스트")
    void add_distance_specification_number() {
        Distance distance = Distance.of(3);
        Distance targetDistance = Distance.of(2);


        Distance newDistance = targetDistance.add(2);


        Assertions.assertThat(newDistance.fartherThan(distance)).isTrue();
    }
}
