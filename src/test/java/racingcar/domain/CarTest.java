package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 움직임 테스트")
    void move() {
        //given

        final int START_LOCATION = 0;
        final int MOVE_STRATEGY = 1;
        final int expectLocation = START_LOCATION + MOVE_STRATEGY;
        Car car = new Car(START_LOCATION);

        //when
        car.move(true);

        //then
        assertThat(car.getCurrentLocation()).isEqualTo(expectLocation);
    }

    @Test
    @DisplayName("get 현재 위치 테스트")
    void getCurrentLocation() {
        //given
        final int NOW_LOCATION = 2;
        Car car = new Car(NOW_LOCATION);

        //when
        int expectLocation = car.getCurrentLocation();
        //then
        assertThat(expectLocation).isEqualTo(NOW_LOCATION);
    }


    @Test
    @DisplayName("Cars getSize 테스트")
    void getSize() {
        //given
        final int carNumber = 5;
        Cars cars = new Cars(carNumber);

        //when
        int resultCarSize = cars.getSize();

        //then
        assertThat(resultCarSize).isEqualTo(carNumber);
    }

    @Test
    @DisplayName("자동차들을 움직이게 시켰을 때 움직임 전략에 따른 테스트")
    void moveCars() {
        //given
        final int carNumber = 3;
        Cars expectCars = new Cars(carNumber);
        MoveStrategy stubMoveStrategy = new CarsTest.StubMoveStrategy();
        for (int i = 0; i < carNumber; i++) {
            expectCars.getCars().get(i).move(true);
        }

        //when
        Cars resultCars = new Cars(carNumber);
        resultCars.move(stubMoveStrategy);

        //then
        for (int i = 0; i < carNumber; i++) {
            Car resultCar = resultCars.getCars().get(i);
            Car expectCar = expectCars.getCars().get(i);
            assertThat(resultCar.getCurrentLocation()).isEqualTo(expectCar.getCurrentLocation());
        }
    }

}
