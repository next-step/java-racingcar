package carracing;

import org.junit.jupiter.params.ParameterizedTest;
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

}