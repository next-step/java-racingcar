package step3.util.numberGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = {11, 12})
    @DisplayName("랜덤으로 생성할 수 있는 숫자의 범위는 10 미만이어야 한다.")
    void randomly_generatedNumber_range_test(int number) {
        assertThatThrownBy(() -> new RandomNumberGenerator().generate(number)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("고정 번호 생성기는 입력된 숫자가 리턴되어야 한다.")
    void fixed_generatedNumber_test(int number) {
        assertThat(new FixedNumberGenerator().generate(number)).isEqualTo(number);
    }
}