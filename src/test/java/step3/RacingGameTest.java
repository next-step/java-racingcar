package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.RacingInformation;
import step3.strategy.draw.DashDrawStrategy;
import step3.strategy.move.RandomMoveStrategy;
import step3.view.InputView;
import step3.view.PrintView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingGameTest {

    private static final String FORCED_TERMINATION_USER_GUIDE = "사용자에 의해 프로그램이 종료되었습니다";


    @Test
    @DisplayName("레이싱 게임은 유저한 입력한 숫자만큼 레이싱카를 생성한다")
    public void 레이싱카_생성_테스트() {
        int numberOfCars = 4;
        int numberOfReps = 5;
        RacingInformation racingInformation = RacingInformation.of(numberOfCars, numberOfReps);
        RacingGame racingGame = RacingGame.of(InputView.getInstance(), PrintView.of(DashDrawStrategy.getInstance()), RandomMoveStrategy.getInstance());

        assertThat(racingGame.makeRacingCarList(racingInformation)).hasSize(numberOfCars);
    }

    @Test
    @DisplayName("레이싱 게임은 유저한 입력한 숫자만큼 레이싱게임을 진행한다")
    public void 레이싱게임_테스트() {
        int numberOfCars = 4;
        int numberOfReps = 5;
        RacingInformation racingInformation = RacingInformation.of(numberOfCars, numberOfReps);
        RacingGame racingGame = RacingGame.of(InputView.getInstance(), PrintView.of(DashDrawStrategy.getInstance()), RandomMoveStrategy.getInstance());

        assertThat(racingGame.play(racingGame.makeRacingCarList(racingInformation),racingInformation)).hasSize(numberOfReps);
    }


    @Test
    @DisplayName("레이싱 게임은 강제종료시 예외를 던진다")
    public void 레이싱_강제종료_테스트() {

        RacingGame racingGame = RacingGame.of(InputView.getInstance(), PrintView.of(DashDrawStrategy.getInstance()), RandomMoveStrategy.getInstance());

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(racingGame::stop)
                .withMessageContaining(FORCED_TERMINATION_USER_GUIDE);
    }


}