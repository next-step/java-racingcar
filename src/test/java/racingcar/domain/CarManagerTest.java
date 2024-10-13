package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarManagerTest {

    @Test
    void 빈_목록_생성() {
        assertThatThrownBy(() ->
                new CarManager(new ArrayList<>())
        ).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 차이름_중복() {

        assertThatThrownBy(() ->
                new CarManager(Arrays.asList(new Car("a"), new Car("a")))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}