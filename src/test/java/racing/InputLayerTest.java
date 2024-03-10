package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputLayerTest {
    @Test
    @DisplayName("정수가 아닐 경우 예외를 반환한다.")
    void InvalidInputThenException(){
        assertThatThrownBy(()->InputLayer.convertToInt("one")).isInstanceOf(IllegalArgumentException.class);
    }
}