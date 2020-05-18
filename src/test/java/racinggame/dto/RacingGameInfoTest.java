package racinggame.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.exception.RacingGameInputException;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameInfoTest {

    static Stream<Arguments> racingGameInfo() {
        return Stream.of(
                Arguments.of("가, 나", "0", "시도횟수는 0보다 커야합니다"),
                Arguments.of("가", "-1", "시도횟수는 0보다 커야합니다"),
                Arguments.of("가, 나, 다", "문자", "시도횟수는 숫자로 입력해야합니다. : 문자")
        );
    }

    @DisplayName("시도횟수는 0보다 큰 숫자를 입력하지 않으면 Exception을 던진다")
    @MethodSource("racingGameInfo")
    @ParameterizedTest
    void wrongInput(String participantsCar, String numberOfAttempt, String expectedErrorMessage) {
        assertThatThrownBy(() -> new RacingGameInfo(participantsCar, numberOfAttempt))
                .isInstanceOf(RacingGameInputException.class)
                .hasMessage(expectedErrorMessage);
    }

    @DisplayName("자동차 이름에 중복, 공백이 들어오면 Exception을 던진다")
    @ValueSource(strings = {"a,b,c,c", " ,a,b"})
    @ParameterizedTest
    void duplicateOrEmpty(String carNames) {
        assertThatThrownBy(() -> new RacingGameInfo(carNames, "2"))
                .hasMessage("자동차 이름은 공백, 중복이 존재해서는 안됩니다");
    }

    @DisplayName("자동차 이름은 중복, 공백이 없고, 시도횟수는 0이상의 숫자이면 정상적으로 생성된다")
    @Test
    void goodCase() {
        //given
        String carNames = "a, b, c";
        String numberOfAttempt = "5";
        RacingGameInfo racingGameInfo = new RacingGameInfo(carNames, numberOfAttempt);

        //when
        List<String> carNamesResult = racingGameInfo.getCarNames();
        int numberOfAttemptResult = racingGameInfo.getTotalRound();

        //then
        assertAll(
                () -> assertThat(carNamesResult).containsExactly("a", "b", "c"),
                () -> assertThat(numberOfAttemptResult).isEqualTo(5)
        );
    }

}


