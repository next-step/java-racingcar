package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {


    @Test
    void getCarSize() {
        //given
        final int carNumber = 5;
        Cars cars = new Cars(carNumber);

        //when
        int resultCarSize = cars.getCarsSize();

        //then
        assertThat(resultCarSize).isEqualTo(carNumber);
    }

    @Test
    void moveOneCar() {
        //given
        final int index = 2;
        final Boolean isMove = true;
        final int MOVE_STRATEGY = 1;
        final int START_LOCATION = 0;
        final int carNumber = 5;
        Cars cars = new Cars(carNumber);

        //when
        cars.moveOneCar(index, isMove);
        Car resultCar = cars.getCars().get(index);

        //then
        assertThat(resultCar.getCurrentLocation()).isEqualTo(START_LOCATION + MOVE_STRATEGY);
    }


}
