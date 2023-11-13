package racing.controller;

import common.StringSpliter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.CarMoveStrategy;
import racing.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {


    @DisplayName("자동차 이름을 포함하여 레이싱 게임을 생성한다. '김동규'의 차가 항상 승리한다.")
    @Test
    void create_racing_game_with_user_name_always_donggyu_win() {
        // given
        final String userNameAnswer = "김동규,박동규";
        String[] userNames = StringSpliter.getSplittedString(userNameAnswer);
        final int gameCount = 3;
        FixedNumberStrategy fixedNumberStrategy = new FixedNumberStrategy(List.of(5, 1, 5, 1, 5, 1));
        RacingGame racingGame = new RacingGame(userNames, gameCount, fixedNumberStrategy);
        RacingGameController racingGameController = new RacingGameController(racingGame);

        // when
        racingGameController.repeatRace();

        // then
        assertThat(racingGame).isNotNull();
        assertThat(racingGame.getRacingCars())
                .extracting("carName")
                .containsExactly("김동규", "박동규");

        assertThat(racingGame.getWinners())
                .extracting("carName")
                .containsExactly("김동규")
        ;
    }


    static class FixedNumberStrategy extends CarMoveStrategy {

        private final List<Integer> numbers;
        private int index;

        public FixedNumberStrategy(List<Integer> numbers) {
            this.numbers = numbers;
            this.index = 0;
        }

        public int getMoveSource() {
            if (index < numbers.size()) {
                return numbers.get(index++);
            }
            return numbers.get(index);    // out of range exception 방지를 위해 예상한 횟수보다 많이 요청이 발생하는 경우 마지막 값을 반환
        }
    }
}
