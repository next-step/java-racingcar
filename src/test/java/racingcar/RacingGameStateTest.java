package racingcar;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameStateTest {

    private String[] carNames = {"seo", "yeong", "sy"};
    private int tryNo = 3;

    @Test
    public void 차량_초기화() {
        RacingGameState racingGameState = new RacingGameState(carNames, tryNo);
        List<Car> cars = racingGameState.getCars();
        assertThat(cars).hasSize(carNames.length);
    }

    @Test
    public void 이름_초기화() {
        RacingGameState racingGameState = new RacingGameState(carNames, tryNo);
        List<String> carNames = racingGameState.getCars()
                .stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
        assertThat(carNames).containsAnyOf(this.carNames);
    }

}
