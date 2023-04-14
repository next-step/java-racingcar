package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    void 각_자동차는_주어진_횟수만큼_이동한다() {
        int carCount = 5;
        int moveCount = 3;
        Cars cars = new Cars(carCount, moveCount);
        RacingCarGame.progress(cars);

        // 실제로 모든 차가 주어진 횟수만큼 이동했느지 판단할 수 있는 방법....?
        assertThat(RacingCarGame.getRound()).isEqualTo(moveCount);
        assertThat(cars.values().size()).isEqualTo(carCount);
        cars.values().forEach(car -> {
            assertThat(car.position()).isBetween(0, moveCount);
        });
    }

}
