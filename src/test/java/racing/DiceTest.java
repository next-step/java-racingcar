package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


@DisplayName("주사위 클래스 테스트")
class DiceTest {

    @Test
    @DisplayName("주사위 범위 테스트")
    void castDiceTest() {
        assertThat(Dice.cast()).isBetween(0, 9);
    }

}