package racing.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.RacingGame;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {
    @Test
    @DisplayName("자동차의 대수는 0 이상이어야 한다.")
    void carNumTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(Collections.emptyList()));
    }

    @Test
    @DisplayName("이름이 같은 자동차는 중복 제거가 되어야 한다.")
    void distinctTest() {
        RacingGame racingGame = new RacingGame(Lists.list(new Car("test"), new Car("test")));

        assertThat(racingGame.getCars()).hasSize(1);
    }

    @Test
    @DisplayName("String[] 으로 RacingGame 객체를 생성할 수 있다.")
    void constructorTest() {
        RacingGame racingGame = new RacingGame(new String[] {"testCar1", "testCar2"});

        assertThat(racingGame.getCars()).hasSize(2);
    }

    @Test
    @DisplayName("제일 Position 이 큰 자동차가 우승이다")
    void gameWinnerTest() {
        Car car1 = makeTestCar("car1", 1);
        Car car2 = makeTestCar("car2", 2);
        Car car3 = makeTestCar("car3", 3);
        RacingGame racingGame = new RacingGame(Lists.list(car1, car2, car3));

        List<Car> winners = racingGame.getWinners();

        assertThat(winners).containsOnly(car3);
    }

    @Test
    @DisplayName("우승자가 여러차 일 수 있다.")
    void multipleWinnerTest() {
        Car car1 = makeTestCar("car1", 1);
        Car car2 = makeTestCar("car2", 1);

        RacingGame racingGame = new RacingGame(Lists.list(car1, car2));

        assertThat(racingGame.getWinners()).hasSize(2);
    }

    private Car makeTestCar(String name, int position) {
        Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            car.moveForward(4);
        }
        return car;
    }
}