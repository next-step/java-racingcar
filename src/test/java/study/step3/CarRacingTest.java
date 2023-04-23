package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    CarRacing carRacing = new CarRacing();

    List<Car> cars;

    public CarRacingTest() {

        cars = new ArrayList<Car>();
        cars.add(new Car("A", 12));
        cars.add(new Car("B", 7));
        cars.add(new Car("C", 18));
        cars.add(new Car("D", 18));
        cars.add(new Car("E", 3));
    }

    @DisplayName("차량의 위치가 일치하는지 비교한다.")
    @ParameterizedTest
    @CsvSource(value = {"A:12", "B:7", "C:18", "E:3"}, delimiter = ':')
    public void 자동차_점수_비교_A차량_우승(String carName, int position) throws Exception {
        assertThat(new Car(carName, position).isCarPosition(position)).isTrue();
    }

    @Test
    @DisplayName("0~9 사이 무작위 값을 반환한다.")
    public void random_함수_test() throws Exception {
        for (int i = 0; i < 10; i++) {
            assertThat(carRacing.getRandomInt())
                    .isGreaterThan(-1)
                    .isLessThan(10);
        }
    }
}
