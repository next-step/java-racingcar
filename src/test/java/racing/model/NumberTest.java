package racing.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("숫자 테스트")
public class NumberTest {

    @DisplayName("Number 객체 생성시 주입받은 숫자 값을 그대로 갖는다.")
    @Test
    public void unchangedNumberValueTest() {
        // given
        int givenNumber = 3;

        // when
        Number number = new Number(givenNumber);

        // then
        assertEquals(number.getNumber(), givenNumber);
    }

    @DisplayName("0에서 9 사이의 숫자가 아니라면, IllegalArgumentException이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-10, -3, -1, 10, 20, 30})
    public void outOfBoundsNumberExceptionTest(int number) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(number))
                .withMessage(String.format("값이 유효한 범위 안에 있지 않습니다. (number: %d)", number));
    }
}
