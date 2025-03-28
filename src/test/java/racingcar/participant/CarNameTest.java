package racingcar.participant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNameTest {

    @Test
    void 자동차_이름_생성이_성공한다() {
        new CarName("123");
    }

    @Test
    void 자동차_이름이_5글자이상이면_Exception이_발생한다() {
        assertThatThrownBy(() -> {
            new CarName("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}