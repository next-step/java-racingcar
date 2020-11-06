package step4.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.MustMoveStrategy;
import step4.dto.RacingGameConditionDTO;
import step4.dto.RacingGameConditionMoveStrategyDTO;
import step4.exception.MinimumTryCountException;
import step4.exception.ValidateBlankName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"wani,pobi:1", "wani,pobi:2", "wani,pobi:3"}, delimiter = ':')
    @DisplayName("게임이 잘 되는지 확인한다.")
    void runGame(String carNames, int tryCount) {
        RacingGame racingGame = getRacingGameInstance(carNames, tryCount);
        for (int i = 0; i < tryCount; i++) {
            racingGame.runRound();
        }

        assertThat(racingGame.getTopPositionCarNames()).isEqualTo(carNames);

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

    private RacingGame getRacingGameInstance(String carNames, int tryCount) {
        return RacingGame.of(
                RacingGameConditionMoveStrategyDTO.of(
                        RacingGameConditionDTO.of(carNames, tryCount), new MustMoveStrategy()));
    }

}