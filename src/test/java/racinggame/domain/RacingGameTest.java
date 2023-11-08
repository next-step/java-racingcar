package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingGameTest {

    @Test
    void 자동차들을_입력_받아_게임을_생성_할_수_있다() {
        List<Car> cars = List.of(
            new Car(new CarName("pobi")));
        RacingGame racingGame = new RacingGame(new Cars(cars));

        int actual = racingGame.carsCount();
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "게임을 진행하면 자동차가 전진 혹은 정지한다 (number = {0})")
    @CsvSource({"false, 0", "true, 1"})
    void play(boolean movable, int distance) {
        List<Car> cars = List.of(new Car(new CarName("pobi")));
        RacingGame racingGame = new RacingGame(new Cars(cars));
        racingGame.play(new TestMovingStrategy(movable));

        Cars actual = racingGame.cars();
        Cars expected = new Cars(List.of(new Car(new CarName("pobi"), new Distance(distance))));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차들이_이동한_거리를_표출_할_수_있다() {
        List<Car> cars = List.of(
            new Car(new CarName("pobi"), new Distance()),
            new Car(new CarName("crong"), new Distance(2)));
        RacingGame racingGame = new RacingGame(new Cars(cars));

        List<Distance> actual = racingGame.report();
        List<Distance> expected = List.of(new Distance(), new Distance(2));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 우승한_자동차를_추출_할_수_있다() {
        List<Car> cars = List.of(
            new Car(new CarName("pobi"), new Distance()),
            new Car(new CarName("crong"), new Distance(2)));
        RacingGame racingGame = new RacingGame(new Cars(cars));

        Cars actual = new Cars(List.of(new Car(new CarName("crong"), new Distance(2))));
        Cars expected = racingGame.winners();

        assertThat(actual).isEqualTo(expected);
    }

}
