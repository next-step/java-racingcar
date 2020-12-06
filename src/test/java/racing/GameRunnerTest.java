package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameRunnerTest {

    @Test
    @DisplayName("2대의 자동차, 2번 움직일때, 랜덤숫자 1일경우 아무 자동차도 안움직임")
    void cant_move() {
        Cars cars = new Cars(Arrays.asList(new Car(), new Car()));
        GameRunner gameRunner = new GameRunner(cars, 2);
        RandomNumberGenerator randomNumberGenerator = new TestRandomNumberGenerator(1);
        Cars results = gameRunner.play(randomNumberGenerator);
        assertThat(results.getCars().get(0).getMoveCount()).isEqualTo(0);
        assertThat(results.getCars().get(1).getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("2대의 자동차, 3번 움직일때, 랜덤숫자 4일 경우 모두 세번 앞으로 전진")
    void can_move() {
        Cars cars = new Cars(Arrays.asList(new Car(), new Car()));
        GameRunner gameRunner = new GameRunner(cars, 3);
        RandomNumberGenerator randomNumberGenerator = new TestRandomNumberGenerator(4);
        Cars results = gameRunner.play(randomNumberGenerator);
        assertThat(results.getCars().get(0).getMoveCount()).isEqualTo(3);
        assertThat(results.getCars().get(1).getMoveCount()).isEqualTo(3);
    }
}