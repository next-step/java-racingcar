package step4.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.MustMoveStrategy;
import step4.dto.RacingGameConditionDTO;
import step4.dto.RacingGameConditionMoveStrategyDTO;
import step4.exception.ValidateBlankName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"wani,pobi:1", "wani,pobi:2", "wani,pobi:3"}, delimiter = ':')
    @DisplayName("게임이 잘 되는지 확인한다.")
    void runGame() {
    }

    @ParameterizedTest
    @CsvSource(value = {"wani,pobi:1", "wani,pobi:2", "wani,pobi:3"}, delimiter = ':')
    @DisplayName("게임의 진행횟수를 확인한다.")
    void validGameTryCount(String carNames, int tryCount) {

        RacingGame racingGame = getRacingGameInstance(carNames, tryCount);
        assertThat(racingGame.getRacingGameTryCount()).isEqualTo(tryCount);

    }

    @ParameterizedTest
    @CsvSource(value = {"wani:1", "wani,pobi:2", "wani,pobi,jun:3"}, delimiter = ':')
    @DisplayName("게임을 위한 자동차 수가 맞는지 확인한다.")
    void validGameCarCount(String carNames, int carCount) {
        int tryCount = 1;
        RacingGame racingGame = getRacingGameInstance(carNames, tryCount);
        assertThat(racingGame.splitToCarList(
                racingGame.getRacingGameCarNames()).size()).isEqualTo(carCount);

    }

    private RacingGame getRacingGameInstance(String carNames, int tryCount) {
        return RacingGame.of(
                RacingGameConditionMoveStrategyDTO.of(
                        RacingGameConditionDTO.of(carNames, tryCount), new MustMoveStrategy()));
    }

    @Test
    @DisplayName("자동차 이름이 빈값일때 익셉션 확인")
    void throwExceptionMinCarCount() {
        //then
        assertThatThrownBy(() -> getOutBoundCarListSizeExceptionGameSetting()).isInstanceOf(ValidateBlankName.class);

    }

    private RacingGame getOutBoundCarListSizeExceptionGameSetting() {
        return RacingGame.of(
                RacingGameConditionMoveStrategyDTO.of(
                        RacingGameConditionDTO.of(" ", 1), new MustMoveStrategy()));
    }
}