package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.gameobject.RacingGame;
import step3.rule.FirstRacerLoseRule;
import step3.rule.FirstRacerWinRule;
import step3.rule.StubbingTrueRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    public void nameCheckTest() {
        assertThatThrownBy(() -> {
            List<String> nameList = List.of("test", "테스트용자동차이름");
            RacingGame racingGame = new RacingGame(nameList, new StubbingTrueRule());
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    private static final List<String> racerList = List.of("r1", "r2", "r3");

    @DisplayName("경주 진행마다 각자 이름을 가진 결과를 반환한다.")
    @Test
    public void raceTest() {
        // given
        RacingGame racingGame = new RacingGame(racerList, new StubbingTrueRule());

        // when
        List<String> result = racingGame.race();

        // then
        assertThat(result).hasSize(racerList.size());
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i)).isEqualTo(racerList.get(i) + " : --");
        }
    }

    @Test
    @DisplayName("가장 많이 움직인 사람이 우승한다. : 우승자가 유일한 경우")
    public void getWinnerTestWithSingleWinner() {
        RacingGame racingGame = new RacingGame(racerList, new FirstRacerWinRule());

        racingGame.race();

        List<String> winnerList = racingGame.getWinner();
        assertThat(winnerList).hasSize(1);
        assertThat(winnerList).containsExactlyElementsOf(List.of("r1"));
    }

    @DisplayName("가장 많이 움직인 사람이 우승한다. : 우승자가 2명인 경우")
    @Test
    public void getWinnerTestWithManyWinners() {
        RacingGame racingGame = new RacingGame(racerList, new FirstRacerLoseRule());

        racingGame.race();

        List<String> winnerList = racingGame.getWinner();
        assertThat(winnerList).hasSize(2);
        assertThat(winnerList).containsExactlyElementsOf(List.of("r2", "r3"));
    }

}