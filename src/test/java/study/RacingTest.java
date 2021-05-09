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


    @DisplayName("차 이름 리스트에 담기")
    @Test
    void playerCar() {
        assertThat(Racing.playerCar("chloe,chloe")).containsExactly("chloe", "chloe");
    }

    @DisplayName("차 이름 5자가 넘으면 예외처리")
    @Test
    void throwIllegalArgumentException() {
        assertThatThrownBy(() -> Racing.playerCar("chloe,chloeJ")).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("우승자")
    @Test
    void winner() {
        List<Car> cars = new ArrayList<Car>();

        cars.add(new Car("chloe",4));
        cars.add(new Car("tt",5));
        cars.add(new Car("ss",5));

        assertThat(Racing.getWinners(cars)).containsExactly("tt","ss");
    }



    @DisplayName("차 전진 여부")
    @Test
    void movedTest() {
        Car aCar = new Car("name");
        Racing.moved(6, aCar);
        assertThat(aCar.getMovingRange()).isEqualTo(1);
    }


}
