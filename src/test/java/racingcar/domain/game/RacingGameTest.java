package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domain.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @Nested
    @DisplayName("레이싱 게임 성공 케이스 테스트")
    class SuccessCondition {

        private RacingGame racingGame;

        @BeforeEach
        void init() {
            this.racingGame = new RacingGame("엄태권,OWEN,서버마법사", 5);
        }

        @Test
        @DisplayName("게임횟수를 5회로 생성한 후 게임을 5회 진행시 게임은 끝이난다.")
        void endGame_isEnd() {
            for (int i = 0; i < 5; i++) {
                this.racingGame.startRacing(() -> false);
            }

            assertThat(this.racingGame.isEndGame()).isTrue();
        }

        @Test
        @DisplayName("게임횟수를 5회로 생성한 후 게임을 4회만 진행시 게임은 아직 끝나지 않는다.")
        void endGame_notEnd() {
            for (int i = 0; i < 4; i++) {
                this.racingGame.startRacing(() -> true);
            }

            assertThat(this.racingGame.isEndGame()).isFalse();
        }


        @Test
        @DisplayName(",로 구분된 '엄태권,OWEN,서버마법사'로 게임을 생성시 자동차는 3대가 된다.")
        void createCar_3대() {
            Cars cars = this.racingGame.getCars();

            assertThat(cars.getCars()).hasSize(3);
        }
    }

    @Nested
    @DisplayName("레이싱게임 실패 케이스 테스트")
    class FailCondition {

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("자동차 게임 생성시 자동차의 이름을 입력하지 않으면 오류가 발생한다.")
        void createGame_자동차0대(String inputString) {
            assertThatThrownBy(() -> new RacingGame(inputString, 5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("최소 한 글자 이상을 입력해야 합니다.");
        }

        @Test
        @DisplayName("중간에 비어있는 이름을 입력하는 경우 '엄태권,,서버마법사' 자동차 생성에 실패한다.")
        void createGame_비어있는이름() {
            assertThatThrownBy(() -> new RacingGame("엄태권,,서버마법사", 5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차의 이름은 비어있을 수 없습니다.");
        }

        @Test
        @DisplayName("이름이 5글자 이상인 자동차가 있을 경우 자동차 생성에 실패한다.")
        void createGame_5글자이상() {
            assertThatThrownBy(() -> new RacingGame("엄태권,T,ServerWizard", 5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차의 이름은 5글자를 초과할 수 없습니다. 초과된 자동차 : ServerWizard");
        }

        @Test
        @DisplayName("자동차 게임 생성시 0회의 게임을 생성하면 오류가 발생한다.")
        void createGame_게임0회() {
            assertThatThrownBy(() -> new RacingGame("엄태권,Owen,ServerWizard", 0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("최소 1번 이상의 게임을 진행해야 합니다.");
        }
    }
}