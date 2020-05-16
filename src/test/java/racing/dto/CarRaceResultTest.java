package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRaceResultTest {

    @ParameterizedTest
    @MethodSource("provideNotValidCarNames")
    @DisplayName("유효하지 않은 자동 이름 전달 시 Exception")
    void validateCarRaceResultByEmptyName(String carName, int position) {
        this.carRaceResultExceptionTest(carName, position);
    }

    private CarRaceResult createCarRaceResult(String carName, int position) {
        return new CarRaceResult(carName, position);
    }

    private static Stream<Arguments> provideNotValidCarNames() {
        return Stream.of(
                Arguments.of("", 1),
                Arguments.of(null, 1)
        );
    }

    private void carRaceResultExceptionTest(String carName, int position) {
        assertThatThrownBy(() -> this.createCarRaceResult(carName, position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideNotValidPositions")
    @DisplayName("유효하지 않은 자동차 위치 전달 시 Exception")
    void validateCArRaceResultByNotValidPosition(String carName, int position) {
        this.carRaceResultExceptionTest(carName, position);
    }

    private static Stream<Arguments> provideNotValidPositions() {
        return Stream.of(
                Arguments.of("test1", -1),
                Arguments.of("test2", -999)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCarRaceResultInformation")
    @DisplayName("CarRaceResult carName 반환값 검증")
    void getCarNameTest(String carName, int position) {
        CarRaceResult carRaceResult = this.createCarRaceResult(carName, position);
        assertThat(carRaceResult.getCarName()).isEqualTo(carName);
    }

    private static Stream<Arguments> provideCarRaceResultInformation() {
        return Stream.of(
                Arguments.of("test1", 1),
                Arguments.of("test2", 2),
                Arguments.of("test4", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCarRaceResultInformation")
    @DisplayName("CarRaceResult position 반환값 검증")
    void getPositionTest(String carName, int position) {
        CarRaceResult carRaceResult = this.createCarRaceResult(carName, position);
        assertThat(carRaceResult.getPosition()).isEqualTo(position);
    }
}
