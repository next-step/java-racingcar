package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.State;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {


    private Cars cars;

    @BeforeEach
    public void setup() {

        this.cars = new Cars(
                Arrays.asList(
                        new Car("jeje"),
                        new Car("tdd"),
                        new Car("nextstep")
                ));
    }

    @Test
    @DisplayName("1회 모두 전진했을 때, max값 증가 테스트")
    void goingTrySuccess() {
        cars.goingTry(() -> true);
        State other = new State(1);
        for (Car car : cars.getCars()) {
            assertThat(car.getState().equals(other)).isTrue();
        }

    }

    @Test
    @DisplayName("1회 모두 멈춰있했을 때, max값 변동없음 테스트")
    void goingTryFail() {
        cars.goingTry(() -> false);
        State other = new State(0);
        for (Car car : cars.getCars()) {
            assertThat(car.getState().equals(other)).isTrue();
        }
    }

    @Test
    @DisplayName("우승자 찾기 테스트")
    void findWinner() {
        cars = new Cars(Arrays.asList(
                new Car("jeje", 10),
                new Car("tdd", 5),
                new Car("nextstep", 8))
                , new State(10));
        List<String> winners = cars.findWinners();
        assertThat(winners).contains("jeje");
    }

}
