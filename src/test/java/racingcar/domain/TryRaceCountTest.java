package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class TryRaceCountTest {

    @Test
    void 음수또는0이면_예외발생(){
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new TryRaceCount(-1);
            });
    }
}
