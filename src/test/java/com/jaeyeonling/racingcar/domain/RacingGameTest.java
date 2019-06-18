package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("RacingGame 객체 생성")
    @Test
    void newRacingGame() {
        assertThat(new RacingGame(RacingGameOption.builder().nameOfParticipants("TestCar").build())).isNotNull();
    }

    @DisplayName("RacingGame 게임 완료 테스트")
    @Test
    void completeGame() {
        // given
        final int moveCount = 10;
        final RacingGameOption gameOption = RacingGameOption.builder()
                .movingCount(moveCount)
                .nameOfParticipants("TestCar")
                .build();
        final RacingGame game = new RacingGame(gameOption);

        // when
        for (int i = Car.DEFAULT_POSITION; i < moveCount; i++) {
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
    void playGame(String nameOfParticipants,
                  int moveCount) {
        final int participantsLength = nameOfParticipants.split(RacingGameOption.NAME_SEPARATOR).length;

        // given
        final MoveStrategy mockAlwaysMoveStrategy = i -> true;
        final StringBuilder expectResultBuilder = new StringBuilder();
        for (int i = 0; i < participantsLength; i++) {
            expectResultBuilder.append(nameOfParticipants).append(" : ");
            for (int j = 0; j < moveCount; j++) {
                expectResultBuilder.append(Car.VISUAL_POSITION_STRING);
            }
            expectResultBuilder.append(StringUtils.NEW_LINE);
        }

        // when
        final RacingGameOption racingGameOption = RacingGameOption.builder()
                .moveStrategy(mockAlwaysMoveStrategy)
                .movingCount(moveCount)
                .nameOfParticipants(nameOfParticipants)
                .build();

        final RacingGame racingGame = new RacingGame(racingGameOption);
        for (int i = Car.DEFAULT_POSITION; i < moveCount; i++) {
            racingGame.move();
        }

        // then
        assertThat(racingGame.getParticipants().visualize()).isEqualTo(expectResultBuilder.toString());
    }

    @DisplayName("RacingGame 공동 우승 테스트")
    @ParameterizedTest
    @CsvSource({
            "'a,b,c,d,e',4",
            "'a,b,c,d,e',6",
            "'a,b,c,d,e',5",
            "'a,b,c,d,e',3",
            "'a,b,c,d,e',346",
            "'a,b,c,d,e',45",
            "'a,b,c,d,e',454"
    })
    void everyoneVictory(String nameOfParticipants,
                         int moveCount) {
        // given
        final MoveStrategy mockAlwaysMoveStrategy = i -> true;

        // when
        final RacingGameOption racingGameOption = RacingGameOption.builder()
                .moveStrategy(mockAlwaysMoveStrategy)
                .movingCount(moveCount)
                .nameOfParticipants(nameOfParticipants)
                .build();

        final RacingGame racingGame = new RacingGame(racingGameOption);
        for (int i = Car.DEFAULT_POSITION; i < moveCount; i++) {
            racingGame.move();
        }

        final String victors = racingGame.getResult()
                .getVictors()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(RacingGameOption.NAME_SEPARATOR));

        // then
        assertThat(nameOfParticipants).isEqualTo(victors);
    }
}
