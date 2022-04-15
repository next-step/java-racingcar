package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("각 자동차는 4이상의 숫자가 들어오면 움직인다.")
    void 자동차들_움직임_테스트(){
        int carCnt = 3;
        List<Integer> moveCntList = List.of(4, 5, 6);

        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCnt; i++){
            carList.add(new Car());
        }

        Cars cars = new Cars(carList);

        cars.moveAll(moveCntList);

        assertThat(cars.checkPositions(List.of(1, 1, 1))).isTrue();
    }

    @Test
    @DisplayName("각 자동차는 3이하의 숫자가 들어오면 움직이지 않는다.")
    void 자동차들_움직임_테스트2(){
        int carCnt = 3;
        List<Integer> moveCntList = List.of(1, 2, 3);

        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCnt; i++){
            carList.add(new Car());
        }

        Cars cars = new Cars(carList);

        cars.moveAll(moveCntList);

        assertThat(cars.checkPositions(List.of(0, 0, 0))).isTrue();
    }
}
