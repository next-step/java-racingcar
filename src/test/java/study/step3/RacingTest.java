package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.Racing;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingTest {

    private Racing racing = new Racing();

    @Test
    @DisplayName("checkInput 메소드 carCount 0 체크 : IllegalArgumentException")
    void carCountZeroTest() {
        assertThatThrownBy(() -> racing.checkInput(0, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 0대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("checkInput 메소드 gameCount 0 체크 : IllegalArgumentException")
    void gameCountZeroTest() {
        assertThatThrownBy(() -> racing.checkInput(1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 횟수는 0번 이상이어야 합니다.");
    }

    @DisplayName("getMoveNumberTest 메소드 테스트")
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "9, 1"
    })
    void getMoveNumberTest(int number, int result) {
        assertEquals(result, racing.getMoveNumber(number));
    }

    @DisplayName("getRaceResult 메소드 테스트")
    @Test
    void getRaceResultTest() {
        int[][] result = racing.getRaceResult(3, 5);

        assertEquals(5, result.length);
        assertEquals(3, result[0].length);
    }

}
