package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class PositionTest {

    @Test
    @DisplayName("생성자로 넘긴 int 값과 getValue() 값이 일치하는지 테스트")
    void getValue() {
        then(new Position(0).getValue()).isEqualTo(0);
        then(new Position(new Position(0), 1).getValue()).isEqualTo(1);
    }
}