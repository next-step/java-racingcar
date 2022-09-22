package step3.racinggame.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    // '모든 로직에 단위 테스트를 구현한다.' 때문에 만든 테스트 클래스인데요,
    // 제가 제대로 요구사항을 이해한건지 확신이 서지 않습니다...


    @Test
    @DisplayName("주어진 차 수만큼 차량 생성 테스트")
    void init_cars() {
        RacingGame game = new RacingGame();
        List<Car> cars = game.readyToRace(3);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 경기 수만큼 게임 후 점수 생성 테스트")
    void play_game_get_scores() {
        RacingGame game = new RacingGame();
        List<Car> cars = game.readyToRace(3);

        List<List<Integer>> result = game.playGame(5, cars);

        assertThat(result.size()).isEqualTo(5);
    }

}