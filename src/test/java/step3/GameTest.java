package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

//    @DisplayName("Game Start 시 Time 만큼 step() 메서드를 호출 한다.")
//    @ParameterizedTest
//    @CsvSource(value = {"4:5:5", "6:3:5"}, delimiter = ':')
//    void startTest() {
//    }

//    @DisplayName("Step() 메서드는 ")


}