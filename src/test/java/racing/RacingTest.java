package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private List<Car> cars;
    private Racing racing;
    private Random createRandom(int returnValue) {
        return new Random() {
            public int nextInt(int bound) {
                return returnValue;
            };
        };
    }

    @BeforeEach
    void set() {
        cars = new ArrayList<>();
        cars.add(new Car("chloe"));
        cars.add(new Car("tt"));
        racing = new Racing(cars);
    }

    /*
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.")
    @Test
    void winner() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("chloe",4));
        cars.add(new Car("tt",5));
        cars.add(new Car("ss",5));

        Racing racing = new Racing(cars);
        assertThat(racing.printWinner()).containsExactly("tt","ss");
    }
     */

    @DisplayName("전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.")
    @Test
    void movedTest() {
        racing.moved(6, cars.get(0));
        assertThat(cars.get(0).getMovingRange()).isEqualTo(1);
    }

    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @Test
    void randomTest() {

    }
}
