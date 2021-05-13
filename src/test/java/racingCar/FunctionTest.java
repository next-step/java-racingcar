package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void testMoveAble() {
        // given
        int number = 4;
        Function function = new Function();

        // when
        boolean actual = function.moveAble(number);

        // then
        assertTrue(actual);
    }

    @Test
    @DisplayName("자동차 전진 실패 테스트")
    void testNotMoveAbleTest() {
        // given
        int number = 2;
        Function function = new Function();

        // when
        boolean actual = function.moveAble(number);

        // then
        assertFalse(actual);
    }

    @Test
    @DisplayName("자동차가 전진하여 점수 얻기 테스트")
    void getScoreTest() {
        // given
        int number = 2;
        Function function = new Function();

        // when
        boolean actual = function.moveAble(number);

        // then
        assertFalse(actual);
    }


}
