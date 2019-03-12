package racingcar.domain;

import org.junit.Test;
import racingcar.vo.RacingGameRound;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameInfoTest {

    @Test
    public void 다음_라운드_여부_확인() {
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        int totalRount = 5;
        RacingGameRound racingGameRound = new RacingGameRound(totalRount);

        RacingGameInfo racingGameInfo = new RacingGameInfo(cars, racingGameRound);
        assertThat(racingGameInfo.hasNextRound()).isTrue();

        for (int i = 0; i < totalRount; i++) {
            racingGameInfo.incrementCurrentRound();
        }

        assertThat(racingGameInfo.hasNextRound()).isFalse();
    }

}
