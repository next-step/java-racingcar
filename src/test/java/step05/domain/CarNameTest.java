package step05.domain;

import exception.EmptyException;
import exception.OutOfBoundLength;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarNameTest {

    @DisplayName("이름이 비었는지 검사")
    @ParameterizedTest
    @NullAndEmptySource
    public void test_isBlank(String blackName) {
        assertThatExceptionOfType(EmptyException.class)
                .isThrownBy(() -> CarName.of(blackName));
    }

    private static Stream<Arguments> provideOverDefaultLengthCarName() {
        return Stream.of(
                Arguments.of(
                        "123456",
                        "asdasdasdsadsadsa",
                        "asdasdsad",
                        "123213ads"
                )
        );
    }

    @DisplayName("이름이 default 5자 초과일때 에러")
    @ParameterizedTest
    @MethodSource("provideOverDefaultLengthCarName")
    public void isInBoundLength_overDefaultLengthCarName_throwException(String outOfBoundCarName) {
        assertThatExceptionOfType(OutOfBoundLength.class)
                .isThrownBy(() -> CarName.of(outOfBoundCarName));
    }

    private static Stream<Arguments> provideOverMaxLengthCarName() {
        return Stream.of(
                Arguments.of("123456", 4),
                Arguments.of("asdasdasdsadsadsa", 10)
        );
    }

    @DisplayName("이름이 default maxLength 자 초과일때 에러")
    @ParameterizedTest
    @MethodSource("provideOverMaxLengthCarName")
    public void isInBoundLength__overMaxLengthCarName_throwException(String outOfBoundCarName, int maxLength) {
        assertThatExceptionOfType(OutOfBoundLength.class)
                .isThrownBy(() -> CarName.of(outOfBoundCarName, maxLength));
    }

    private static Stream<Arguments> provideUnderMaxLengthCarName() {
        return Stream.of(
                Arguments.of("123456", 7),
                Arguments.of("asd", 3),
                Arguments.of("asd", 4)
        );
    }

    @DisplayName("이름이 maxLength 자 이하일 때 에러 없음")
    @ParameterizedTest
    @MethodSource("provideUnderMaxLengthCarName")
    public void isInBoundLength__underMaxLengthCarName_throwException(String inBoundCarName, int maxLength) {
        assertThatCode(() -> CarName.of(inBoundCarName, maxLength))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름 객체 반환")
    @Test
    public void test_getName() {
        String name = "name";
        CarName carName = CarName.of(name);
        assertThat(carName).isEqualTo(carName.getName());
    }

}
