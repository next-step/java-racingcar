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
}
