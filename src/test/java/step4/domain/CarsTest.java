package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {


    @Test
    @DisplayName("Cars에 있는 Car들이 잘 움직이는지 확인한다.")
    void moveCars() {
        //given
        List<Car> carList = Arrays.asList(new Car("wani"), new Car("pobi"));
        Cars cars = new Cars(carList);
        MoveStrategy moveStrategy = new MustMoveStrategy();
        //when
        cars.moveCars(moveStrategy);
        List<Integer> carsPositions = cars.getCarsStatus().stream()
                .map(Car::getCarPosition)
                .collect(Collectors.toList());
        //then
        carsPositions.forEach(carsPosition -> assertThat(carsPosition).isEqualTo(1));
    }



}