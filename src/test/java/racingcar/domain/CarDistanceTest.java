package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarDistanceTest {

    @Test
    void 생성자_거리_기본값은_0() {
        assertThat(new CarDistance().getValue()).isZero();
    }

    @Test
    void increase_거리는_1씩_증가() {
        CarDistance distance = new CarDistance();

        distance.increase();

        assertThat(distance.getValue()).isOne();
    }

    @Test
    void increase_여러번_호출_시_거리가_누적된다() {
        CarDistance distance = new CarDistance();

        distance.increase();
        distance.increase();
        distance.increase();

        assertThat(distance.getValue()).isEqualTo(3);
    }
}
