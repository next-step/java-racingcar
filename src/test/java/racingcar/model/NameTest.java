package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {
    @Test
    void 아이디_유효성_검사_5글자초과() {
        String carName = "wu2eee";
        assertThatThrownBy(() -> new Name(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 아이디_유효성_검사_0글자() {
        String carName = "";
        assertThatThrownBy(() -> new Name(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}
