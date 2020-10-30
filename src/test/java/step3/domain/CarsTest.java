package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = Arrays.asList(new Car(), new Car());
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("Cars에 있는 Car들이 잘 움직이는지 확인한다.")
    void moveCars() {
        //given
        MoveStrategy moveStrategy = new MustMoveStrategy();
        //when
        cars.moveCars(moveStrategy);
        List<Integer> carsPositions = cars.getCarsPosition();
        //then
        carsPositions.forEach(carsPosition -> assertThat(carsPosition).isEqualTo(1));
    }

}