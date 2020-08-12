package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarList;
import racingcar.RacingCar;
import racingcar.RandomMove;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private static final Car car = new Car();
    private static final int standard_movement = 0;
    private static final int bound = 1;
    private static final RandomMove randomMove = new RandomMove(standard_movement, bound);
    private static final int carNum = 1;
    private static final int tryNum = 1;

    @Test
    @DisplayName("차 이동했는지 테스트")
    void isCarMove() {
        car.move();
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("차 리스트 생성 테스트")
    void isCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(car);

        CarList cars = new CarList(carList);

        assertThat(cars.getCar()).isEqualTo(carList);
    }

    @Test
    @DisplayName("차 이동 가능 여부")
    void canCarMove() {
        assertThat(randomMove.canMove()).isTrue();
    }

    @Test
    @DisplayName("차 움직임 테스트")
    void canCarPlay() {
        RacingCar racingCar = new RacingCar(carNum, tryNum, randomMove);
        racingCar.racingPlay();

        List<Car> carList = new ArrayList<>();
        carList.add(car);
        CarList cars = new CarList(carList);

        cars.move(randomMove);

        assertThat(cars.getCar()).isEqualTo(racingCar.getCarList());
    }
}
