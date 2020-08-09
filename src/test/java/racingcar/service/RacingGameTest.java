package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingRound;
import racingcar.view.InputValidater;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingGameTest {

    @ParameterizedTest
    @ValueSource(strings = {"YANG,KYUNG,JUN"})
    @DisplayName("자동차 경주 게임 동작 테스트")
    void startTest(String carNames) {

        // given
        String expectedMark1 = "YANG : -\nKYUNG : -\nJUN : -\n";
        String expectedMark2 = "YANG : --\nKYUNG : --\nJUN : --\n";
        String expectedMark3 = "YANG : ---\nKYUNG : ---\nJUN : ---\n";

        // when
        List<String> racingCarNames = Arrays.asList(carNames.split(","));
        RacingGameStub racingGameStub = new RacingGameStub(racingCarNames, racingCarNames.size());
        racingGameStub.start();
        List<RacingRound> racingResults = racingGameStub.getRoundResults();

        ResultView resultView = new ResultView(racingResults);

        List<String> displayResult = racingResults.stream()
                .map(racingRound -> resultView.printRoundResult(racingRound))
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
    @ValueSource(strings = {"YANG,KYUNG,JUN7575"})
    @DisplayName("자동차 이름 유효성 검사 테스트")
    public void validate_car_names(String racingCarNames) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputValidater.validateCarNames(racingCarNames);
                }).withMessageMatching("자동차 이름은 숫자와 문자 조합이고 5자를 초과할 수 없습니다.");
    }
}
