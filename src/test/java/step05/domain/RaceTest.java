package step05.domain;

import exception.NotPositiveIntegerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RaceTest {

    private static Stream<Arguments> provideNotPositiveIntegerResult() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(-10),
                Arguments.of(0)
        );
    }

    @DisplayName("경주 횟수가 양수가 아닐때 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideNotPositiveIntegerResult")
    public void test_validateNumberOfMoves(int NotPositiveInteger) {
        assertThatExceptionOfType(NotPositiveIntegerException.class)
                .isThrownBy(() -> Race.of(NotPositiveInteger));
    }

//    @DisplayName("경주 운행 결과")
//    @ParameterizedTest


    @DisplayName("승자 확인")
    @ParameterizedTest
    @MethodSource("provideLastCarsStatusResult")
    public void test_findWinner() {

    }

    /*
        - 멤버
        - 경주 횟수 private final int numberOfMoves
        - 경주에 참여시킬 자동차들 private final Cars cars;
    - 생성자
        - 경주 횟수를 검증하고 검증횟수, 경주에 참여시킬 자동차들을 초기화
    - 메서드
        - 경주 횟수 검증 (양수인지) private static void validateNumberOfMoves
        - 경주 운행 public void operate()
        - 승자를 리턴 private static String getWinner(List<Car> cars)
     */
}
