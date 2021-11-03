package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameTest {

    @DisplayName("Game 생성 시에 RuleDto에 count나 time 은 null이면 안된다.")
    @Test
    void ofTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Game.of(Rule.from(null, 10));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Game.of(Rule.from(10, null));
        });
    }


}