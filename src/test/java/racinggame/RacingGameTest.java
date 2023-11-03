package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    void 자동차들을_입력_받아_게임을_생성_할_수_있다() {
        List<Car> cars = List.of(new Car(new MovingValidator(new TestMovingStrategy())));
        RacingGame racingGame = new RacingGame(cars);
        int actual = racingGame.carsCount();
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }

}
