package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarFactoryTest {

    @ParameterizedTest
    @DisplayName("문자열을 입력하였을 때 자동차의 이동거리가 0으로 초기화 되었는 지 테스트")
    @MethodSource("provideStringsForCarLocationInitTest")
    void isCarLocationIsZeroWhenParsingInput(String input, int expected) {
        List<Car> actual = CarFactory.generateCars(input);

        actual.forEach((car) -> assertThat(car.getLocation()).isEqualTo(expected));
    }

    private static Stream<Arguments> provideStringsForCarLocationInitTest() {
        return Stream.of(
                Arguments.of("hello,world,test", 0),
                Arguments.of("hello,test", 0),
                Arguments.of("hello", 0)
        );
    }

    @ParameterizedTest
    @DisplayName("입력한 문자열의 자동차 수와 Car의 Size가 일치하는 지 테스트")
    @MethodSource("provideStringsForCarSizeTest")
    void isCarSizeEqualWithInput(String input, int expected) {
        List<Car> actual = CarFactory.generateCars(input);

        assertThat(actual.size()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringsForCarSizeTest() {
        return Stream.of(
                Arguments.of("hello,world,test,car", 4),
                Arguments.of("hello,test", 2),
                Arguments.of("hello", 1)
        );
    }
}
