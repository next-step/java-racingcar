package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    CarRacing carRacing = new CarRacing();

    Car[] cars;

    public CarRacingTest() {
        cars = new Car[5];
        cars[0] = new Car("A", 12);
        cars[1] = new Car("B", 7);
        cars[2] = new Car("C", 18);
        cars[3] = new Car("D", 18);
        cars[4] = new Car("E", 3);
    }

    @Test
    @DisplayName("가장 멀리간 차량의 위치를 출력한다.")
    public void 우승자_위치_확인() throws Exception {
        assertThat(carRacing.findCarMaxPosition(cars).getPosition()).isEqualTo(18);
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
