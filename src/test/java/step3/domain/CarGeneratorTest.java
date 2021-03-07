package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 자동차 생성자 테스트
 */
class CarGeneratorTest {

    private static Stream<Arguments> generateCarValue() {
        return Stream.of(
                Arguments.of(3, 3),
                Arguments.of(4, 4),
                Arguments.of(2, 2)
        );
    }

    @DisplayName("자동차 생성자 테스트")
    @ParameterizedTest(name = "{0} 입력 값을 통해 생성되는 자동차 인스턴스 갯수 {1}")
    @MethodSource(value = "generateCarValue")
    void test(int createdSize, int expectedSize) {
        List<Car> of = CarGenerator.of(createdSize);
        assertThat(of.size()).isEqualTo(expectedSize);
    }
}
