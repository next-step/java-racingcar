package carracing.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class TestRandomNumberGeneratorTest {

    @DisplayName("테스트용 난수 생성기에 입력한 값을 그대로 반환 받을 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100})
    void getFixedNumber(int number) {
        // given
        TestFixedNumberGenerator testFixedNumberGenerator = new TestFixedNumberGenerator(number);

        // when
        int result = testFixedNumberGenerator.generate();

        // then
        assertThat(result).isEqualTo(number);
    }

}