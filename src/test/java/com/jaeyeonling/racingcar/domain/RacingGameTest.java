package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("RacingGame 객체 생성")
    @Test
    void newRacingGame() {
        assertThat(new RacingGame(RacingGameOption.builder().build())).isNotNull();
    }

    @DisplayName("RacingGame 게임 완료 테스트")
    @Test
    void completeGame() {
        // given
        final RacingGameOption gameOption = RacingGameOption.builder().build();
        final RacingGame game = new RacingGame(gameOption);

        // when
        while (!game.isComplete()) {
            game.move();
        }

        // then
        assertThat(game.isComplete()).isTrue();
    }

    @DisplayName("RacingGame 게임 완료 테스트")
    @ParameterizedTest
    @CsvSource({
            "3,4",
            "5,6",
            "10,5",
            "5,3",
            "345,346",
            "32,45",
            "665,454"
    })
    void playGame(int numberOfParticipants,
                  int moveCount) {
        // given
        final MoveStrategy mockAlwaysMoveStrategy = () -> true;
        final StringBuilder expectResultBuilder = new StringBuilder();
        for (int i = numberOfParticipants; i > 0; i--) {
            for (int j = moveCount; j > 0; j--) {
                expectResultBuilder.append(Car.VISUAL_POSITION_STRING);
            }
            expectResultBuilder.append(StringUtils.NEW_LINE);
        }

        // when
        final RacingGameOption racingGameOption = RacingGameOption.builder()
                .moveStrategy(mockAlwaysMoveStrategy)
                .movingCount(moveCount)
                .numberOfParticipants(numberOfParticipants)
                .build();

        final RacingGame racingGame = new RacingGame(racingGameOption);
        while (!racingGame.isComplete()) {
            racingGame.move();
        }

        // then
        assertThat(racingGame.getStatus().visualize()).isEqualTo(expectResultBuilder.toString());
    }
}
