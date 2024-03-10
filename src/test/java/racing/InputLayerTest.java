package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputLayerTest {
    @Test
    void 정수가_아닐경우_예외를반환한다(){
        assertThatThrownBy(()->InputLayer.convertToInt("한개")).isInstanceOf(IllegalArgumentException.class);
    }
}