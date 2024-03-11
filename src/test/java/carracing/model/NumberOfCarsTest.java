package carracing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberOfCarsTest {
    @Nested
    @DisplayName("NumberOfCars 생성자 테스트")
    class ConstructorTest {
        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {"abcd", "-1", "0", "1.123", "1,a12"})
        @DisplayName("생성자의 파라미터로 양의 정수를 전달하지 않는 경우 IllegalArgumentException을 발생시킨다.")
        void testFailCase(String input) {
            assertThatThrownBy(() -> NumberOfCars.newNumber(input))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "10", "111"})
        @DisplayName("생성자의 파라미터로 양의 정수를 전달하지 하는 경우 정상적으로 NumberOfCars의 인스턴스를 생성한다.")
        void testSuccessCase(String input) {
            assertThatObject(NumberOfCars.newNumber(input))
                    .isExactlyInstanceOf(NumberOfCars.class);
        }
    }
}