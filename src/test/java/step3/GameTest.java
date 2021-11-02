package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @DisplayName("Game 생성 시에 RuleDto에 count나 time 은 null이면 안된다.")
    @Test
    void ofTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Game.of(RuleDto.from(null, 10L));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Game.of(RuleDto.from(10L, null));
        });
    }


}