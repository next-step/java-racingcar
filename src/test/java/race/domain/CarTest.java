package race.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

    @ParameterizedTest(name = "4이상이면_움직이고_3이하이면_움직이지못한다.")
    @CsvSource(value = {"4:1", "5:1", "1:0", "2:0", "3:0"}, delimiter = ':')
    void move(int number, int count) {
        // Given
        Car car = Car.createInstance("test");

        // When
        car.move(number);

        // Then
        assertThat(car.getPosition().getValue()).isEqualTo(count);
    }

    @Test
    void 이름이5글자가_초과하면_예외발생() {
        // Given
        String name = "default";
        // When & Then
        assertThatThrownBy(() -> Car.createInstance(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("providePositionsAndBoolean")
    void isSamePosition_테스트(int position1, int position2, boolean expected) {
        // Given
        Car test1 = Car.createInstance("test1");
        Car test2 = Car.createInstance("test2");

        // When
        test1.move(position1);
        test2.move(position2);

        // Then
        assertThat(test1.isEqualPosition(test2.getPosition().getValue())).isEqualTo(expected);
    }

    private static Stream<Arguments> providePositionsAndBoolean() {
        return Stream.of(
                Arguments.of(4,3, false),
                Arguments.of(4,4, true)
        );
    }
}