package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @Test
    @DisplayName("게임횟수를 5회로 생성한 후 게임을 5회 진행시 게임은 끝이난다.")
    void endGame_isEnd() {
        RacingGame racingGame = new RacingGame(2, 5);

        for (int i = 0; i < 5; i++) {
             racingGame.startRacing();
        }

        assertThat(racingGame.isEndGame()).isTrue();
    }

    @Test
    @DisplayName("게임횟수를 5회로 생성한 후 게임을 4회만 진행시 게임은 아직 끝나지 않는다.")
    void endGame_notEnd() {
        RacingGame racingGame = new RacingGame(2, 5);

        for (int i = 0; i < 4; i++) {
            racingGame.startRacing();
        }

        assertThat(racingGame.isEndGame()).isFalse();
    }


    @Test
    @DisplayName("자동차 게임 생성시 2대의 자동차를 생성하면 cars의 size는 2가 된다.")
    void createCar_2대() {
        RacingGame racingGame = new RacingGame(2, 5);

        Cars cars = racingGame.getCars();

        assertThat(cars.getCars()).hasSize(2);
    }

    @Test
    @DisplayName("자동차 게임 생성시 0대의 자동차를 생성하면 오류가 발생한다.")
    void createGame_자동차0대() {
        assertThatThrownBy(() -> new RacingGame(0, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 1개 이상의 자동차를 만들어야합니다.");
    }

    @Test
    @DisplayName("자동차 게임 생성시 0회의 게임을 생성하면 오류가 발생한다.")
    void createGame_게임0회() {
        assertThatThrownBy(() -> new RacingGame(2, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 1번 이상의 게임을 진행해야 합니다.");
    }
}