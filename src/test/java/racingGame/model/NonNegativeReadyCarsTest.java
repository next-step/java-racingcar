package racingGame.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NonNegativeReadyCarsTest {
    
    @Test
    void carSetTest() {
        String[] strings = {};
        assertThatThrownBy(() -> {
            new NonNegativeReadyCars(strings);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("%s", "참가시킬 자동차 수 입력이 생략되거나, 0이하");
    }
    
}