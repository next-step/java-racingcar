package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputOutputTest {

    @DisplayName("사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다")
    @Test
    void input() {
        RacingGame game = new RacingGame(5, "pobi,crong,honux");
        RacingGameResult result = game.run();

        assertThat(result.getNumberOfCars()).isEqualTo(3);
        assertThat(result.getRecordOfCar(0).size()).isEqualTo(5);
    }

    @DisplayName("레이싱 결과 데이터를 온전히 읽어들일 수 있어야 한다")
    @Test
    void output() {
        List<Car> sample = Arrays.asList(
                new Car("pobi", Arrays.asList(1, 2, 2, 3, 3)),
                new Car("crong", Arrays.asList(1, 1, 1, 2, 2)),
                new Car("honux", Arrays.asList(1, 2, 3, 4, 4))
        );
        RacingGameResult result = new RacingGameResult(sample);

        assertThat(result.getNumberOfCars()).isEqualTo(3);
        assertThat(result.getRecordOfCar(0)).containsExactly(1, 2, 2, 3, 3);
        assertThat(result.getRecordOfCar(1)).containsExactly(1, 1, 1, 2, 2);
        assertThat(result.getRecordOfCar(2)).containsExactly(1, 2, 3, 4, 4);
    }
}
