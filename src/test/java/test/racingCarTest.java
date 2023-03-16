package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.Car;
import racingCar.RacingGame;

public class racingCarTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("pobi,woni,jun", 5);
    }

    @DisplayName("자동차경주")
    @Test
    void racingTest() {
        racingGame.race();
    }

    @DisplayName("자동차경주")
    @Test
    void racingTest2() {
        System.setIn(new ByteArrayInputStream("pobi,woni,jun\n5".getBytes()));
        RacingGame racingGame = new RacingGame();
        racingGame.race();
    }

    @DisplayName("자동차는 이름을 가진다.")
    @Test
    void hasName() {
        final Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @DisplayName("자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.")
    @Test
    void racingInputLengthErrorTest() {
        assertThatThrownBy(() -> {
            new Car("November");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 초기 위치는 0이다.")
    @Test
    void showInitPosition() {
        final Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 현재 위치를 알 수 있다.")
    @Test
    void getCurrentPosition() {
        Car car = new Car("june", 10);
        assertThat(car.getPosition()).isEqualTo(10);
    }

    @DisplayName("자동차가 4 이상일 때 전진한다.")
    @Test
    void move() {
        Car car = new Car("june");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 4 미만일 때 정지한다.")
    @Test
    void stop() {
        Car car = new Car("june");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차들 중에서 가장 멀리 간 위치가 어디인지 알 수 있다.")
    @Test
    void far() {
        racingGame.race();
        System.out.println(racingGame.findMaxPosition());
    }

    @DisplayName("자동차 한 대가 우승한 경우")
    @Test
    void winner() {
        List<Car> cars = Arrays.asList(
            new Car("pobi", 2),
            new Car("crong", 3),
            new Car("honux", 1)
        );

        List<Car> winner = RacingGame.getWinner(3, cars);
    }

    @DisplayName("자동차 여러대가 우승한 경우")
    @Test
    void winners() {
        List<Car> cars = Arrays.asList(
            new Car("pobi", 3),
            new Car("crong", 3),
            new Car("honux", 1)
        );

        List<Car> winners = RacingGame.getWinner(3, cars);
    }
}
