package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingSupportTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("prepareCar() 메서드는 입력값 만큼의 길이를 가진 Car 객체 배열을 반환한다")
    void prepare_int_to_array(int input) {
        Car[] cars = RacingSupport.prepareCar(input);
        int carCount = cars.length;
        assertThat(carCount).isEqualTo(input);
    }

    @Test
    @DisplayName("moveByRandom() 메서드 isMove 파라미터가 true 면 location 한 칸 증가한다")
    void move_when_isMove_true(){
        Car[] cars = new Car[1];
        cars[0] = new Car();
        Car[] movedCar = RacingSupport.moveByRandom(true, cars, 0);

        assertThat(movedCar[0].getLocation()).isEqualTo(1);
    }
}