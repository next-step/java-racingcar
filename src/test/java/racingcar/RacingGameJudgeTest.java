package racingcar;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameJudgeTest {
    private List<String> carNames = Arrays.asList("pobi", "crong", "honux");

    @Test
    public void 우승자_확인() {
        RacingGameJudge racingGameJudge = new RacingGameJudge();

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        Car winner1 = cars.get(0);
        Car winner2 = cars.get(1);
        winner1.go();
        winner2.go();

        List<Car> winners = racingGameJudge.getWinners(cars);
        assertThat(winners)
                .containsExactly(winner1, winner2);
    }

}
