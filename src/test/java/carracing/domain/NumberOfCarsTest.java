package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberOfCarsTest {
    @Nested
    @DisplayName("NumberOfCars 인스턴스 생성 테스트")
    class InstanceCreationTest {
        @Nested
        @DisplayName("인스턴스 생성 시 주어진 파라미터가 문자열인 경우 테스트")
        class StringParameterCaseTest {
            @ParameterizedTest
            @NullAndEmptySource
            @ValueSource(strings = {"abcd", "-1", "0", "1.123", "1,a12"})
            @DisplayName("양의 정수인 문자열을 전달하지 않는 경우 IllegalArgumentException을 발생시킨다.")
            void testFailCaseStringParameter(String input) {
                assertThatThrownBy(() -> NumberOfCars.newNumber(input))
                        .isExactlyInstanceOf(IllegalArgumentException.class);
            }

            @ParameterizedTest
            @ValueSource(strings = {"1", "2", "10", "111"})
            @DisplayName("양의 정수인 문자열을 전달하 하는 경우 정상적으로 NumberOfCars의 인스턴스를 생성한다.")
            void testSuccessCaseStringParameter(String input) {
                assertThatObject(NumberOfCars.newNumber(input))
                        .isExactlyInstanceOf(NumberOfCars.class);
            }
        }

        @Nested
        @DisplayName("인스턴스 생성 시 주어진 파라미터가 정수인 경우 테스트")
        class IntegerParameterCaseTest {
            @ParameterizedTest
            @ValueSource(ints = {-1, 0, -22, -12})
            @DisplayName("양의 정수를 전달하지 않는 경우 IllegalArgumentException을 발생시킨다.")
            void testFailCaseStringParameter(int input) {
                assertThatThrownBy(() -> NumberOfCars.newNumber(input))
                        .isExactlyInstanceOf(IllegalArgumentException.class);
            }

            @ParameterizedTest
            @ValueSource(ints = {1, 2, 10, 11})
            @DisplayName("양의 정수를 전달하 하는 경우 정상적으로 NumberOfCars의 인스턴스를 생성한다.")
            void testSuccessCaseStringParameter(int input) {
                assertThatObject(NumberOfCars.newNumber(input))
                        .isExactlyInstanceOf(NumberOfCars.class);
            }
        }
    }
}