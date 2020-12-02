package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.MoveRule;
import racingcar.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        List<String> carName = new ArrayList<>();
        carName.add("car1");
        carName.add("car2");
        carName.add("car3");
        Cars cars = new Cars(carName);

        racingGame = RacingGame.newRacingGame(cars, 3, new MoveRule());
    }

    @Test
    @DisplayName("시도 횟수만큼 기록이 저장되는지 확인")
    public void play_test() {
        racingGame.play();
        assertThat(racingGame.getRaceRecords().getRaceRecords().size()).isEqualTo(3);
    }
}
