package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.MoveStrategy;
import step3.exception.OutBoundCarListSizeException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {


    @Test
    @DisplayName("Cars에 있는 Car들이 잘 움직이는지 확인한다.")
    void moveCars() {
        //given
        List<Car> carList = Arrays.asList(new Car(), new Car());
        Cars cars = new Cars(carList);
        MoveStrategy moveStrategy = new MustMoveStrategy();
        //when
        cars.moveCars(moveStrategy);
        List<Integer> carsPositions = cars.getCarsPosition();
        //then
        carsPositions.forEach(carsPosition -> assertThat(carsPosition).isEqualTo(1));
    }

    @Test
    @DisplayName("자동차 갯수가 1개 미만일때 익셉션 확인")
    void throwExceptionMinCarCount() {
        //given
        List<Car> carList = Collections.emptyList();
        Cars cars;
        //then
        assertThatThrownBy(()-> new Cars(carList)).isInstanceOf(OutBoundCarListSizeException.class);
    }

}