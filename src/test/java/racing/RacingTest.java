package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    @DisplayName("각 자동차에 이름을 부여할 수 있다. ")
    @Test
    void playerCar() {
        assertThat(Racing.playerCar("chloe,chloe")).containsExactly("chloe", "chloe");
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void throwIllegalArgumentException() {
        assertThatThrownBy(() -> Racing.playerCar("chloe,chloeJ")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.")
    @Test
    void winner() {
        List<Car> cars = new ArrayList<Car>();

        cars.add(new Car("chloe",4));
        cars.add(new Car("tt",5));
        cars.add(new Car("ss",5));

        assertThat(Racing.printWinner(cars)).containsExactly("tt","ss");
    }

    @DisplayName("전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.")
    @Test
    void movedTest() {
        Car aCar = new Car("name");
        Racing.moved(6, aCar);
        assertThat(aCar.getMovingRange()).isEqualTo(1);
    }

    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @Test
    void randomTest() {
        List<Car> cars = new ArrayList<Car>();

        cars.add(new Car("chloe"));
        cars.add(new Car("tt"));

        Racing.random(cars, 4);

        List<Integer> movedCars = new ArrayList<>();
        movedCars.add(cars.get(0).getMovingRange());
        movedCars.add(cars.get(1).getMovingRange());

        assertThat(movedCars).contains(0,1);
    }
}
