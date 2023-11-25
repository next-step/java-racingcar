package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @DisplayName("자동차 중 제일 큰 position를 구한 뒤, position의 값이 구한 값과 동일한 자동차를 우승자로 선정한다. 중복허용")
    @Test
    void 자동차_우승자_선정_테스트() {
        //given
        Car car1 = new Car("A", 5);
        Car car2 = new Car("B", 4);
        Car car3 = new Car("C", 5);
        Winner cars = new Winner(List.of(car1, car2, car3));

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(String.join(",",winners)).isEqualTo("A,C");
    }
}
