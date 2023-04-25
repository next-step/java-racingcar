package racingcar;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingGameTest {

    private final int numbOfTrial = 2;
    private final String racingCarName = "abc";

    private RacingGame game;

    @BeforeEach
    void setUp() {
        game = new RacingGame(numbOfTrial,
                List.of(racingCarName),
                new WinnerDecisionByBigLocations());
    }

    @Test
    void 시도횟수_만큼_게임을_진행하면_더이상_진행할수없다() {
        runGameUntilEnd();

        Assertions.assertThatExceptionOfType(GameEndedException.class)
                .isThrownBy(() -> game.runOnce());
    }

    private void runGameUntilEnd() {
        for (int i = 0; i < this.numbOfTrial; i++) {
            game.runOnce();
        }
    }

    @Test
    void 게임을_1회_실행하면_실행결과_자동차_상태를담은_컬렉션을_반환한다() {
        List<CarDto> carDTOs = game.runOnce();

        Assertions.assertThat(carDTOs)
                .haveAtLeastOne(carNamed(racingCarName));
    }

    private Condition<CarDto> carNamed(String name) {
        return new Condition<>(
                carDto -> carDto.getName().equals(name),
                "has name " + name
        );
    }
}
