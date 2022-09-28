package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.BDDAssertions.then;

class PositionTest {

    @Test
    void getValue() {
        then(new Position().getValue()).isEqualTo(0);
        then(new Position(1).getValue()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void increase(int n) {
        Position position = new Position();
        then(position.getValue()).isEqualTo(0);

        position.increase(n);
        then(position.getValue()).isEqualTo(n);
    }
}