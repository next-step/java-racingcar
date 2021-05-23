package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StadiumTest {

    @Test
    @DisplayName("수가 4 이상인지 확인하는 테스트")
    void TestisGreaterThanFour() {
        // when
        Stadium stadium = new Stadium();

        // given
        Boolean actual = stadium.isGreaterThanFour(4);

        // then
        assertTrue(actual);
    }

    @Test
    @DisplayName("수가 4 미만인지 확인하는 테스트")
    void TestisLessThanFour() {
        // when
        Stadium stadium = new Stadium();

        // given
        Boolean actual = stadium.isGreaterThanFour(3);

        // then
        assertFalse(actual);
    }

}
