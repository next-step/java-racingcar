package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingRound;
import racingcar.view.InputValidator;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux,YKJ"})
    @DisplayName("자동차 경주 게임 동작 테스트")
    void startTest(String carNames) {

        // given
        String expectedMark1 = "pobi : -\ncrong : -\nhonux : -\nYKJ : -\n";
        String expectedMark2 = "pobi : --\ncrong : --\nhonux : --\nYKJ : --\n";
        String expectedMark3 = "pobi : ---\ncrong : ---\nhonux : ---\nYKJ : ---\n";

        // when
        List<String> racingCarNames = Arrays.asList(carNames.split(","));
        RacingGameStub racingGameStub = new RacingGameStub(racingCarNames, racingCarNames.size());
        racingGameStub.start();

        List<RacingRound> racingResult = racingGameStub.getRacingResult();

        List<String> displayResult = racingResult.stream()
                .map(racingRound -> ResultView.printRoundResult(racingRound))
                .collect(Collectors.toList());

        // then
        assertAll(
                () -> assertThat(displayResult).hasSize(4),
                () -> assertThat(displayResult).contains(expectedMark1),
                () -> assertThat(displayResult).contains(expectedMark2),
                () -> assertThat(displayResult).contains(expectedMark3)
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"pobi75","crong75","YKJ7575"})
    @DisplayName("자동차 이름 유효성 검사 테스트")
    public void validate_car_names(String racingCarName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    RacingCar racingCar = new RacingCar.RacingCarBuilder(racingCarName)
                            .carPosition(0)
                            .build();
                }).withMessageMatching(InputValidator.INVALID_NAME_ERROR_MESSAGE);
    }

}
