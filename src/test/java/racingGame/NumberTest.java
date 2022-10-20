package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Cars;
import racingGame.domain.Number;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    @DisplayName("인풋값에 음수가 들어오면 에러발생")
    void negativeChk(){
        assertThatThrownBy(() -> {new Number(-1);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수가 들어왔습니다");
    }
}
