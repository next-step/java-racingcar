package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Cars cars;

    public CarsTest() {

        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car("A", 12));
        carList.add(new Car("B", 7));
        carList.add(new Car("C", 18));
        carList.add(new Car("D", 18));
        carList.add(new Car("E", 3));
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("가장 멀리간 차량의 위치를 출력한다.")
    public void 우승자_위치_확인() throws Exception {
        assertThat(cars.findCarMaxPosition().getPosition()).isEqualTo(18);
    }

    @Test
    @DisplayName("가장 멀리간 차량의 이름들을 출력한다.")
    public void 우승자_이름_확인() throws Exception {
        assertThat(cars.findWinners()).isEqualTo("C,D");
    }

}
