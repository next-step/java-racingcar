package racing.domain.generator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DefaultNumberGeneratorTest {

    @Test
    @DisplayName("생성 테스트")
    void constructorTest() {
        assertDoesNotThrow(() -> new DefaultNumberGenerator(10));
    }

    @Test
    @DisplayName("bound값이 0이하면 예외가 발생한다.")
    void below_0_ExceptionTest() {
        Assertions.assertThatThrownBy(() -> new DefaultNumberGenerator(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0이하의 랜덤 값은 만들 수 없습니다.");
    }

    @Test
    @DisplayName("랜덤 10이하로 생성 테스트")
    void below_10_Test() {
        //given
        NumberGenerator randomNumberGenerator = new DefaultNumberGenerator(10);

        //when
        int randomNumber = randomNumberGenerator.randomNumber();

        //then
        assertTrue(randomNumber < 10);
    }
}
