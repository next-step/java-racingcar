package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.extension.Moveable;
import racingcar.domain.response.RacingGamePlayResponse;

@DisplayName("RacingGame 클래스")
class RacingGameTest {

    private final Moveable trueMover = () -> true;
    private final Moveable falseMover = () -> false;

    @Nested
    @DisplayName("new 생성자는")
    class DescribeNewConstructor {

        private final int defaultRound = 0;
        private final List<Car> defeaultCars = List.of(
            new Car("win1", trueMover),
            new Car("loser", falseMover),
            new Car("win2", trueMover)
        );

        @Nested
        @DisplayName("자동차 클래스들과 라운드 정보가 주어진다면,")
        class ContextCarsInput {

            @Test
            @DisplayName("생성을 성공 한다.")
            void ItCreated() {
                assertThatNoException().isThrownBy(() -> new RacingGame(defaultRound, defeaultCars));
            }

        }

        @Nested
        @DisplayName("Cars에 중복된 이름의 Car가 있다면,")
        class ContextDuplicateCarsNameInput {

            private final List<Car> duplicateNameCars = List.of(
                new Car("A", trueMover),
                new Car("A", falseMover),
                new Car("A", trueMover)
            );

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new RacingGame(defaultRound, duplicateNameCars)).isInstanceOf(
                    IllegalArgumentException.class);
            }

        }

        @Nested
        @DisplayName("Empty List가 Cars로 주어진다면,")
        class ContextEmptyCarsInput {

            private final List<Car> emptyCars = List.of();

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new RacingGame(defaultRound, emptyCars)).isInstanceOf(
                    IllegalArgumentException.class);
            }

        }

        @Nested
        @DisplayName("round 값으로 -1이 주어진다면,")
        class ContextNegativeRoundInput {

            private final int negativeRound = -1;

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new RacingGame(negativeRound, defeaultCars)).isInstanceOf(
                    IllegalArgumentException.class);
            }

        }

    }

    @Nested
    @DisplayName("playAndGetPlayResponse 메소드는")
    class DescribePlayAndGetPlayResponseMethod {

        private final List<Car> cars = List.of(
            new Car("A", falseMover),
            new Car("B", falseMover),
            new Car("C", trueMover)
        );

        @Nested
        @DisplayName("RacingGame의 round필드가 1로 바인딩 되어있다면,")
        class ContextRacingGameRound1 {

            private final int round = 1;
            private final RacingGame racingGame = new RacingGame(round, cars);

            @Test
            @DisplayName("한판을 진행하고, 결과를 응답한다.")
            void ItReturn1RoundResult() {
                RacingGamePlayResponse result = racingGame.playAndGetRoundResults();

                assertGamePlayResult(round, cars.size(), List.of("C"), result);
            }

        }

        @Nested
        @DisplayName("RacingGame의 round필드가 3으로 바인딩 되어있다면,")
        class ContextRacingGameRound3 {

            private final int round = 3;
            private final RacingGame racingGame = new RacingGame(round, cars);

            @Test
            @DisplayName("세판을 진행하고, 그 결과를 car에 반영한다.")
            void ItReturn1RoundResult() {
                RacingGamePlayResponse result = racingGame.playAndGetRoundResults();

                assertGamePlayResult(round, cars.size(), List.of("C"), result);
            }

        }

        private void assertGamePlayResult(int expectedRound, int playerCount, List<String> winnerNames,
            RacingGamePlayResponse result) {

            assertThat(result.getRacingGameRoundResponses()).hasSize(expectedRound);

            assertThat(result.getWinnerNames()).containsAll(winnerNames);

            result.getRacingGameRoundResponses().forEach(
                racingGameRoundResponse -> assertThat(racingGameRoundResponse.getCarPerRoundResponses())
                    .hasSize(playerCount));
        }

    }

}
