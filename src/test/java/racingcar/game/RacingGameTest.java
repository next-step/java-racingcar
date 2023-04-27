package racingcar.game;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.game.dto.CarDto;

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
    void 시도횟수_만큼_게임을_실행할수있다() {
        int runCount = 0;

        for (int i = 0; i < numbOfTrial; i++) {
            game.runOnce();
            runCount++;
        }

        Assertions.assertThat(runCount).isEqualTo(numbOfTrial);
    }

    @Test
    void 시도횟수_만큼_게임을_진행하면_더이상_진행할수없다() {
        runGameUntilEnd();

        Assertions.assertThatExceptionOfType(GameException.class)
                .isThrownBy(() -> game.runOnce());
    }

    @Test
    void 게임을_1회_실행하면_실행결과_자동차_상태를담은_컬렉션을_반환한다() {
        List<CarDto> carDTOs = game.runOnce().getCars();

        Assertions.assertThat(carDTOs)
                .haveAtLeastOne(carNamed(racingCarName));
    }

    @Test
    void 종료된_게임인지_알려준다() {
        runGameUntilEnd();

        Assertions.assertThat(game.isEnded()).isTrue();
    }

    @Test
    void 게임이_종료되기_전에는_우승자를_알려주지_않는다() {
        for (int i = 0; i < numbOfTrial - 1; i++) {
            game.runOnce();
        }

        Assertions.assertThatThrownBy(() -> game.winnerCars())
                .hasMessage("게임이 끝나기 전까지 우승자를 알 수 없습니다");
    }

    @Test
    void 게임_종료_후_우승자를_알려준다() {
        runGameUntilEnd();

        Assertions.assertThat(game.winnerCars().getCars())
                .haveAtLeastOne(carNamed(racingCarName));
    }

    private void runGameUntilEnd() {
        for (int i = 0; i < this.numbOfTrial; i++) {
            game.runOnce();
        }
    }

    private Condition<CarDto> carNamed(String name) {
        return new Condition<>(
                carDto -> carDto.getName().equals(name),
                "has name " + name
        );
    }
}
