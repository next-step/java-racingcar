package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.strategy.RandomValueMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:5"}, delimiter = ':')
    @DisplayName("예제외 같이 자동차 대수와 시도횟수를 넣고 자동차 경기를 진행하였을 때, DTO에 담기는 자동차 경기의 시도횟수가 일치한다.")
    void racingGameplayTest_hasSize(String carNames, int tryCount) {
        RacingCarGame racingCarGame = new RacingCarGame(carNames, tryCount);

        assertThat(racingCarGame.play(new RandomValueMovingStrategy()).getRecords()).hasSize(5);
    }
}
