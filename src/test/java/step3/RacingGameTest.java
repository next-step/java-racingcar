package step3;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("prepareCar() 메서드는 입력값 만큼의 길이를 가진 Car 리스트를 반환한다")
    void prepare_int_to_array(int input) {
        List<Car> cars = RacingSupport.prepareCar(input);
        int carCount = cars.size();
        assertThat(carCount).isEqualTo(input);
    }

    @Test
    @DisplayName("moveByRandom() 메서드 isMove 파라미터가 true 면 location 한 칸 증가한다")
    void move_when_isMove_true(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        RacingSupport.moveByRaceRule(true, cars, 0);

        assertThat(cars.get(0).getLocation()).isEqualTo(1);
    }
}