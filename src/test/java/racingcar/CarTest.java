package racingcar;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("차 생성")
    void createCarTest() {
        String[] carStrArr = Arrays.array("pobi", "crong", "honux");
        Cars cars = new Cars(carStrArr);
        List<Car> carList = cars.getCars();
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");
        assertThat(carList).contains(pobi, crong, honux);
    }

    @Test
    @DisplayName("차 생성시, 5자 이상일 경우 에러")
    void checkMaximumTest() {
        String inputStr = "aaaaaa";
        assertThatThrownBy(() -> new Car(inputStr))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차 전진 또는 멈춤")
    void moveCarTest() {
        Car car = new Car("pobi");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(new CarPosition(1));
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(new CarPosition(1));
    }
}
