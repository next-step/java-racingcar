package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.GameRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRunnerTest {
    @Test
    @DisplayName("2대의 자동차, 2번 움직일때, 랜덤숫자 1일경우 아무 자동차도 안움직임")
    void cant_move() {
        //given
        GameRunner gameRunner = createTestGameRunner(2, 2);

        //when
        Cars results = gameRunner.play(new TestRandomNumberGenerator(1));

        //then
        assertThat(results.getCars().get(0).getMoveCount()).isEqualTo(0);
        assertThat(results.getCars().get(1).getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("2대의 자동차, 3번 움직일때, 랜덤숫자 4일 경우 모두 세번 앞으로 전진")
    void can_move() {
        //given
        GameRunner gameRunner = createTestGameRunner(2, 3);

        //when
        Cars results = gameRunner.play(new TestRandomNumberGenerator(4));

        //then
        assertThat(results.getCars().get(0).getMoveCount()).isEqualTo(3);
        assertThat(results.getCars().get(1).getMoveCount()).isEqualTo(3);
    }

    private GameRunner createTestGameRunner(int carNumber, int moveNumber) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carNumber; i++) {
            cars.add(new Car("test" + i));
        }
        return new GameRunner(new Cars(cars), moveNumber);
    }
}