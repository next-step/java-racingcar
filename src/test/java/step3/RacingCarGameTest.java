package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarGameTest {

    @Test
    @DisplayName("사용자는 1회의 시도에 몇 대의 자동차를 사용할지 입력할 수 있다.")
    void inputCarNumbers() {
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String output = RacingCarGame.inputUsers();

        assertThat(output).isEqualTo(input);
    }

    @Test
    @DisplayName("사용자는 1회의 시도에 몇 번의 이동을 할 것인지 입력할 수 있다.")
    void inputMovement() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String output = RacingCarGame.inputMovements();
        assertThat(output).isEqualTo(input);
    }

    @RepeatedTest(100)
    @DisplayName("랜덤 값은 0-9사이의 값이 만들어진다.")
    void makeRandom() {
        Integer randomValue = RacingCarGame.getRandomValue();
        assertTrue(
                randomValue >= 0 && randomValue <= 9,
                "랜덤 값은 0-9 사이의 값이어야 합니다."
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("자동차 경주 게임은 선택된 값이 4이상일 경우 전진한다.")
    void isMove(int number) {
        Boolean move = RacingCarGame.isMove(number);
        if (number < 4) {
            assertThat(move).isFalse();
            return;
        }
        assertThat(move).isTrue();
    }
}
