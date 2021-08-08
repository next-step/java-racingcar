package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;
    private Car carA;
    private Car carB;
    private Car carC;

    @BeforeEach
    void setUp() {
        carA = new Car("carA");
        carB = new Car("carB");
        carC = new Car("carC");

        cars = new Cars(Arrays.asList(carA, carB, carC));
    }

    @Test
    @DisplayName("입력한 자동차 수만큼 객체가 생성됐는지, 입력한 순서대로 저장되었는지 확인한다.")
    void input_car_count() {
        //given
        int expected = 3;

        //when
        List<Car> carList = cars.getCars();

        //then
        assertThat(carList.size()).isEqualTo(expected);
        assertThat(carList.get(0)).isEqualTo(carA);
        assertThat(carList.get(1)).isEqualTo(carB);
        assertThat(carList.get(2)).isEqualTo(carC);
    }

    @Test
    @DisplayName("우승자를 확인한다.")
    void extract_winner_test() {
        //given


        //when
        List<Car> racing = cars.getCars();
        racing.get(0).moveForward(4);
        racing.get(1).moveForward(4);

        //then
        List<Car> cars = this.cars.extractWinner();

        assertThat(cars.get(0)).isEqualTo(carA);
        assertThat(cars.get(1)).isEqualTo(carB);
    }

}