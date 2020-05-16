package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingCarGameTest 클래스 테스트")
public class RacingCarGameTest {

    @Test
    @DisplayName("execute 메소드는 레이싱 게임을 실행한다.")
    void execute() {
        // given
        int carCount = 3;
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.createCars(carCount);

        // when
        racingCarGame.execute();
        List<Car> cars = racingCarGame.getCars();

        // then
        assertThat(cars).isNotNull();
        assertThat(cars.size()).isEqualTo(carCount);
    }
}
