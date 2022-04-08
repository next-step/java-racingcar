package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberFactoryTest {

    @Test
    @DisplayName("정상적인 객체 생성을 확인한다")
    void fromTest() {
        //when
        Number number1 = NumberFactory.from(0);
        Number number2 = NumberFactory.from(1);

        //then
        assertThat(number1).isEqualTo(new Zero());
        assertThat(number2).isEqualTo(new PositiveNumber(1));
    }

    @Test
    @DisplayName("음수 입력 시 예외를 발생시킨다")
    void fromExceptionTest() {
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> NumberFactory.from(-1));
    }

    @ParameterizedTest
    @DisplayName("정상적인 객체 생성을 확인한다")
    @MethodSource("numberProvider")
    void ofTest(List<Integer> sampleNumbers, List<Number> expectedNumbers) {
        //when
        List<Number> numbers = NumberFactory.of(sampleNumbers);

        //then
        assertThat(numbers.containsAll(expectedNumbers)).isTrue();
    }

    static Stream<Arguments> numberProvider() {
        return Stream.of(
                arguments(
                        List.of(0, 1, 2),
                        List.of(new Zero(), new PositiveNumber(1), new PositiveNumber(2))
                ), arguments(
                        List.of(1, 2, 3),
                        List.of(new PositiveNumber(1), new PositiveNumber(2), new PositiveNumber(3))
                )
        );
    }

}