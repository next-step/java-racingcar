package racing;

import edu.next.racing.model.Car;
import edu.next.racing.model.RacingGame;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class RacingTest {

    private String carName = "test";
    private String[] carArray = {"test1","test2"};

    private RacingGame racingGame = new RacingGame(carArray, 2);
    private List<Car> cars;

    private Car car = new TestCar(carName);
    private int carPostion = 1;

    @BeforeEach
    void setRacing() {
        cars = racingGame.execute();
    }

    @DisplayName("자동차 객체 생성 테스트")
    @Test
    void racingGameTest() {
        assertThat(cars).hasSize(carArray.length);
    }

    @DisplayName("자동차 위치 포지션 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 1,1,1,1,1 })
    void carOnlyMovePositionTest(int i) {
        carPostion += i;
        car.move();
        assertThat(car.getPosition()).isEqualTo(carPostion);
    }

    @DisplayName("자동차 이름 테스트")
    @Test
    void carNameTest() {
        assertThat(car.getName()).isEqualTo(carName);
    }
}
