package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingRound;
import racingcar.view.InputValidator;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 경주 게임 동작 테스트")
    void startTest() {

        // given
        int countOfCar = 3;
        int countOfRound = 3;

        String expectedMark1 = "-\n-\n-\n";
        String expectedMark2 = "--\n--\n--\n";
        String expectedMark3 = "---\n---\n---\n";

        // when
        RacingGameStub racingGameStub = new RacingGameStub(countOfCar, countOfRound);
        racingGameStub.start();

        List<RacingRound> racingResult = racingGameStub.getRacingResult();

        List<String> displayResult = racingResult.stream()
                .map(racingRound -> ResultView.printRoundResult(racingRound))
                .collect(Collectors.toList());

        // then
        assertAll(
                () -> assertThat(displayResult).hasSize(3),
                () -> assertThat(displayResult).contains(expectedMark1),
                () -> assertThat(displayResult).contains(expectedMark2),
                () -> assertThat(displayResult).contains(expectedMark3)
        );
    }


    @ParameterizedTest
    @ValueSource(ints = {0, -1, -3})
    @DisplayName("입력 유효성 검사 테스트")
    public void validate_input_test(int inputText) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputValidator.validateInput(inputText);
                }).withMessageMatching(InputValidator.INVALID_INPUT_ERROR_MESSAGE);
    }
}
