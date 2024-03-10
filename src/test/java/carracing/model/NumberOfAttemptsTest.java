package carracing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberOfAttemptsTest {
    @Nested
    @DisplayName("NumberOfAttempts 생성자 테스트")
    class ConstructorTest {
        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {"abcd", "-1", "0", "1.123", "1,a12"})
        @DisplayName("생성자의 파라미터로 양의 정수를 전달하지 않는 경우 IllegalArgumentException을 발생시킨다.")
        void testFailCase(String input) {
            assertThatThrownBy(() -> new NumberOfAttempts(input))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "10", "111"})
        @DisplayName("생성자의 파라미터로 양의 정수를 전달하지 하는 경우 정상적으로 NumberOfAttempts의 인스턴스를 생성한다.")
        void testSuccessCase(String input) {
            assertThatObject(new NumberOfAttempts(input))
                    .isExactlyInstanceOf(NumberOfAttempts.class);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "2:2:true", "3:3:true", "4:5:false", "6:7:false"}, delimiter = ':')
    @DisplayName("isSame(): 클래스 인스턴스 변수 numberOfAttempts와 메서드의 파라미터 값이 일치하면 true 그렇지 않으면 false를 반환한다.")
    void testIsSame(String input, int methodParameter, boolean expected) {
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts(input);
        assertThat(numberOfAttempts.isSame(methodParameter)).isEqualTo(expected);
    }
}