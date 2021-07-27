package racing.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("숫자 테스트")
public class NumberTest {

    @DisplayName("Number 객체 생성시 주입받은 숫자 값을 그대로 갖는다.")
    @Test
    public void initialNumberImmutabilityTest() {
        // given
        int givenNumber = 3;

        // when
        Number number = Number.valueOf(givenNumber);

        // then
        assertEquals(number.getNumber(), givenNumber);
    }

    @DisplayName("0에서 9 사이의 숫자가 아니라면, IllegalArgumentException이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    public void outOfBoundsNumberExceptionTest(int number) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Number.valueOf(number))
                .withMessage(String.format("값이 유효한 범위 안에 있지 않습니다. (number: %d)", number));
    }

    @DisplayName("이전에 이미 생성된 Number 객체의 숫자 값과 같으면, 같은 Number 객체를 재사용한다.")
    @Test
    public void sameNumberReuseTest() {
        // given, when, then
        assertSame(Number.valueOf(5), Number.valueOf(5));
    }
}
