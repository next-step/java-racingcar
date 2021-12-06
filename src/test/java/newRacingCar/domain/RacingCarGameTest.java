package newRacingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    private RacingCarGame racingCarGame;

    @BeforeEach
    void before() {
        racingCarGame = new RacingCarGame(new String[]{"min", "ji", "test"}, 5);
    }

    @Test
    void 생성_테스트() {
        assertThat(racingCarGame).isEqualTo(new RacingCarGame(new String[]{"min", "ji", "test"}, 5));
    }

    @Test
    void 이동_테스트() {
        List<Car> cars = racingCarGame.move(() -> true);
        assertThat(cars.get(0).getPosition().getPosition()).isEqualTo(1);
    }

}
