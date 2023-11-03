package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingGameTest {

    @Test
    void 자동차들을_입력_받아_게임을_생성_할_수_있다() {
        List<Car> cars = List.of(new Car(new MovingValidator(new TestMovingStrategy())));
        RacingGame racingGame = new RacingGame(cars);
        int actual = racingGame.carsCount();
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "게임을 진행하면 자동차가 전진 혹은 정지한다 (number = {0})")
    @CsvSource({"0, 1", "4, 2"})
    void play(int number, int distance) {
        List<Car> cars = List.of(new Car(new MovingValidator(new TestMovingStrategy(number))));
        RacingGame racingGame = new RacingGame(cars);
        racingGame.play();
        Car actual = racingGame.cars().get(0);
        Car expected = new Car(new MovingDistance(distance), new MovingValidator(new TestMovingStrategy()));

        assertThat(actual).isEqualTo(expected);
    }

}
