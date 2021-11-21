package study;

import com.step3.model.car.*;
import com.step3.model.car.strategy.CarMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {
    @Test
    @DisplayName("Car class 생성자 test")
    void create() {
        Car car = new Car(new Name("pobi"), new Position(0), new CarMoveStrategy());
        assertThat(car).isEqualTo(new Car(new Name("pobi"), new Position(0), new CarMoveStrategy()));
    }

    @Test
    @DisplayName("Car move 후 Car class로 return test")
    void move() {
        Car car = new Car(new Name("pobi"), new Position(0), new CarMoveStrategy());
        Car movedCar = new Car(new Name("pobi"), new Position(1), new CarMoveStrategy());

        assertThat(car.move(true).getPosition())
                .isEqualTo(movedCar.getPosition());
    }

    @Test
    @DisplayName("cars의 이동거리 비교 후 우승자 결과 test")
    void getBestCars() {
        Cars cars = Cars.createFromName("pobi,crong,honux".split(","));
        cars.getList().get(0).move(true);   // pobi 이동
        cars.getList().get(1).move(true);   // crong 이동
        assertThat(cars.getWinnerCars().getList()
                .stream()
                .map(c -> c.getName().getValue())
                .collect(Collectors.joining(","))).isEqualTo("pobi,crong");
    }

    @Test
    @DisplayName("자동차 이름 5자 이상 예외처리 test")
    void validateCarName() {
        assertThatThrownBy(() -> Cars.createFromName("pobipobi,crong,honux".split(",")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 5자 이하 필수");
    }
}
