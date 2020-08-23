package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Cars;
import racingcar.RandomMove;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private static final int STANDARD_MOVEMENT = 0;
    private static final int BOUND = 1;
    private static final RandomMove RANDOM_MOVE = new RandomMove(STANDARD_MOVEMENT, BOUND);
    private Car car;
    private List<Car> carList = new ArrayList<>();
    private Cars cars;

    @BeforeEach
    void setup() {
        car = new Car();
        carList.add(car);
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("차 리스트 생성")
    void isCarList() {
        assertThat(cars.getCar()).isEqualTo(carList);
    }

    @Test
    @DisplayName("차들이 움직이는지")
    void isCarsMove() {
        cars.move(RANDOM_MOVE);
        assertThat(1).isEqualTo(cars.getCar().get(0).getPosition());
    }

    @Test
    @DisplayName("차 랜덤에 맞게 이동 가능 여부")
    void canCarMove() {
        assertThat(RANDOM_MOVE.canMove()).isTrue();
    }

}
