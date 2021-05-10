package study;

import Racing.Racing;
import Racing.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {

    Racing racing = new Racing();

    @DisplayName("차 이름 리스트에 담기")
    @Test
    void getCarName() {
        assertThat(racing.getCarName("chloe,chloe")).containsExactly("chloe", "chloe");
    }

    @DisplayName("차 이름 5자가 넘으면 예외처리")
    @Test
    void throwIllegalArgumentException() {
        assertThatThrownBy(() -> racing.getCarName("chloe,chloeJ")).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("우승자")
    @Test
    void winner() {
        List<Car> cars = new ArrayList<Car>();

        cars.add(new Car("chloe", 4));
        cars.add(new Car("tt", 5));
        cars.add(new Car("ss", 5));

        assertThat(racing.getWinners(cars)).containsExactly("tt", "ss");
    }

    @DisplayName("차 전진 여부")
    @Test
    void getRandomMove() {
        Car car = new Car("name");
        assertThat(racing.getRandomMove(6, car)).isEqualToComparingFieldByField(new Car("name", 1));
    }


    @DisplayName("차 전진 여부")
    @Test
    void movedTest() {
        Car aCar = new Car("name");
        racing.getRandomMove(6, aCar);
        assertThat(aCar.getMovingRange()).isEqualTo(1);
    }


}
