package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class PositionTest {

    @Test
    void getValue() {
        then(new Position().getValue()).isEqualTo(0);
        then(new Position(1).getValue()).isEqualTo(1);
        then(new Position(new Position(0), 1).getValue()).isEqualTo(1);
    }
}