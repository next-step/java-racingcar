package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.game.PositiveNumber;
import step3.game.RacingCarGame;
import step3.view.InputView;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarGameTest {

    @Test
    @DisplayName("사용자는 프롬프트로 입력 할 수 있다.")
    void inputCarNumbers() {
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        PositiveNumber output = InputView.inputCarCount();
        assertThat(output.number).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("자동차 경주 게임은 선택된 값이 4이상일 경우 전진한다.")
    void isMove(int number) {
        boolean move = RacingCarGame.isMove(number);
        if (number < 4) {
            assertThat(move).isFalse();
            return;
        }
        assertThat(move).isTrue();
    }
}
