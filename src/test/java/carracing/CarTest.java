package carracing;

import carracing.domain.car.Car;
import carracing.domain.car.Cars;
import carracing.domain.car.strategy.CarMovingConditionByRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Car car;

    @Test
    @DisplayName("Car 객체 생성 후 position 설정")
    void Car_객체생성() {
        car = new Car("car1");
        car.movingCarByPosition(new CarMovingConditionByRandom());
        assertThat(car.getCarName()).isEqualTo("car1");
        assertThat(car.getPosition()).isNotZero();

    }

    @Test
    @DisplayName("자동차 이름 5자 이상 Exception 발생")
    void 자동자이름_테스트() {
        assertThatThrownBy(() -> car = new Car("niceCar"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Cars에 할당후 외부에서 값변경 불가")
    void defensive_copy_테스트() {
        List<Car> carList = new ArrayList<>();
        Cars carsList = new Cars(carList);

        assertThat(carList.size()).isEqualTo(0);
        assertThat(carsList.getCars().size()).isEqualTo(0);

        car = new Car("car1");
        car.movingCarByPosition(new CarMovingConditionByRandom());
        carList.add(car);

        assertThat(carList.size()).isEqualTo(1);
        assertThat(carsList.getCars().size()).isEqualTo(0); //carList에 add 해도 carsList의 객체가 변경되지 않음.

    }
}
