package step05.domain;

import exception.EmptyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarNameTest {

    @DisplayName("이름이 비었는지 검사")
    @ParameterizedTest
    @NullAndEmptySource
    public void test_isBlank(String blackName) {
        assertThatExceptionOfType(EmptyException.class)
                .isThrownBy(() -> CarName.of(blackName));
    }

    private static Stream<Arguments> provideOver5LengthCarName() {
        return Stream.of(
                Arguments.of(
                    "123456",
                    "asdasdasdsadsadsa",
                    "asdasdsad",
                    "123213ads"
                )
        );
    }

    @DisplayName("이름이 5자 초과일때 에러")
    @ParameterizedTest
    @MethodSource("provideOver5LengthCarName")
    public void isInBoundLength__over5LengthCarName_throwError(String outOfBoundCarName) {
        assertThatExceptionOfType(OutOfBoundCarName.class)
                .isThrownBy(() -> CarName.of(outOfBoundCarName));
    }

    /*
        - 이름이 5자 이하인지 검사 private void isInBoundLength
        - 이름 객체 반환 public CarName getName
     */
}
