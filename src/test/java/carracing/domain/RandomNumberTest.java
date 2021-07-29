package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RandomNumberTest {

    @ParameterizedTest(name = "랜덤 값이 0에서 9사이 값이 아닌 경우 예외 발생")
    @ValueSource(ints = {-1, 10})
    public void randomNumberValidationTest(int inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RandomNumber.of(inputNumber))
                .withMessageContaining("랜덤 값이 유효하지 않습니다.");
    }

    @ParameterizedTest(name = "랜덤 값이 0에서 9사이 값인 경우 RandomNumber 객체 생성")
    @ValueSource(ints = {0, 5, 9})
    public void randomNumberCreateSuccessTest(int inputNumber) {
        assertThat(RandomNumber.of(inputNumber))
                .isExactlyInstanceOf(RandomNumber.class);
    }

    @ParameterizedTest(name = "비교 대상 보다 큰 경우 true")
    @CsvSource(value = {"1, 1, false", "1, 2, false", "2, 1, true"})
    public void isOverTest(int targetNumber, int otherNumber, boolean isOver) {
        RandomNumber number = RandomNumber.of(targetNumber);
        assertThat(number.isOver(otherNumber))
                .isEqualTo(isOver);
    }

    @DisplayName("값 객체 캐시 테스트")
    @Test
    public void cacheTest() {
        assertThat(RandomNumber.of(3) == RandomNumber.of(3)).isTrue();
        assertThat(RandomNumber.of(3) == RandomNumber.of(4)).isFalse();
    }

}