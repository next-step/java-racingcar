package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        assertThat(cars.findWinnerNames()).isEqualTo(Arrays.asList(new Name("C"), new Name("D")));
    }

    @Test
    @DisplayName("전달 받은 위치의 차량 이름들을 출력한다.")
    public void 해당_위치의_차량_이름_확인() throws Exception {
        assertThat(cars.findWinnerNames(new Position(7)));
    }

    @Test
    @DisplayName("0~9 사이 무작위 값을 반환한다.")
    public void random_함수_test() throws Exception {
        for (int i = 0; i < 10; i++) {
            assertThat(cars.getRandomInt())
                    .isGreaterThan(-1)
                    .isLessThan(10);
        }
    }

}
