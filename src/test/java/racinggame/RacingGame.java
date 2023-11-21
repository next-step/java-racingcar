package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGame {

    @DisplayName("자동차 전진은 입력된 값이 4이상의 경우 position에 1만큼 더해 준다.")
    @Test
    void 자동차_전진_성공_테스트(){
        //given
        Car car = new Car("A",0);

        //when
        int result = car.move(4);

        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("자동차 전진은 입력된 값이 3이하의 경우 position 변경이 없다.")
    @Test
    void 자동차_전진_불가_테스트(){
        //given
        Car car = new Car("A",0);

        //when
        int result = car.move(3);

        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("자동차 전진은 입력된 값이 음수인 경우 오류가 발생된다.")
    @Test
    void 자동차_전진_오류_테스트(){
        assertThrows(IllegalArgumentException.class, () -> new Car().move(-1));
    }

    @DisplayName("자동차 중 제일 큰 position를 구한 뒤, position의 값이 구한 값과 동일한 자동차를 우승자로 선정한다. 중복허용")
    @Test
    void 자동차_우승자_선정_테스트(){
        //given
        Car car1 = new Car("A", 5);
        Car car2 = new Car("B", 4);
        Car car3 = new Car("C", 5);
        Cars cars = new Cars(list.of(car1, car2, car3));

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(winners).hasSize(2);
    }
}
