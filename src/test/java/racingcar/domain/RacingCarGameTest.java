package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingCarGameTest 클래스 테스트")
public class RacingCarGameTest {

    @Test
    @DisplayName("execute 메소드는 레이싱 게임을 실행하고 GameResult 클래스를 리턴한다.")
    void execute() {
        // given
        List<Car> cars = Arrays.asList(new Car(), new Car());
        RacingCarGame racingCarGame = new RacingCarGame(cars);

        // when
        GameResult actual = racingCarGame.execute();

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getResult()).hasSize(cars.size());
    }
}
