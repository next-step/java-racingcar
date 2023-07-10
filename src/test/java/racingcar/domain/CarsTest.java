package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    void Cars생성시_성공() {
        // given
        final String[] carNames = new String[]{"pobi", "crong", "honux"};

        // when & then
        assertThatNoException().isThrownBy(() -> Cars.of(carNames));
    }
}
