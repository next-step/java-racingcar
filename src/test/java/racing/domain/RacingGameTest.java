package racing.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class RacingGameTest {
    @Test
    @DisplayName("자동차 이름 생성하여 1번 이동한 거리 확인 (테스트 룰 적용)")
    void moveOneTurn() {

        GameRule rule = new TestGameRule();
        RacingGame game = new RacingGame("a,b", 1, rule);

        List<Cars> results = game.playGame();

        assertThat(results.get(0).theCar(0).name()).isEqualTo("a");
        assertThat(results.get(0).theCar(1).name()).isEqualTo("b");

        assertThat(results.get(0).maxLocation()).isGreaterThan(0);
    }

    @Test
    @DisplayName("3번 이동 후 우승자 확인 (테스트 룰 적용)")
    void winners() {

        GameRule rule = new TestGameRule();
        RacingGame game = new RacingGame("a,b", 4, rule);

        List<Cars> results =  game.playGame();

        assertThat(results.get(0).maxLocation()).isGreaterThan(0);
        assertThat(results.get(1).maxLocation()).isGreaterThan(1);
        assertThat(results.get(2).maxLocation()).isGreaterThan(2);

        assertThat(results.get(2).findWinners()).contains("a");
        assertThat(results.get(2).findWinners()).contains("b");
    }
}
