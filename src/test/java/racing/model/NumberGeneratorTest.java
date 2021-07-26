package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;

@DisplayName("랜덤 숫자 생성기 테스트")
public class NumberGeneratorTest {

    @DisplayName("랜덤 숫자를 새로 생성할 때마다, 새로운 숫자 객체가 생성되어야 한다.")
    @Test
    public void getNewRandomNumberTest() {
        // given
        Number number1 = NumberGenerator.getNewRandomNumber();
        Number number2 = NumberGenerator.getNewRandomNumber();

        // when, then
        assertNotSame(number1, number2);
    }
}
