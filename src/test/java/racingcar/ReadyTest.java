package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadyTest {
    @Test
    @DisplayName("이름 배열을 이용해서 자동차 목록 만들기 테스트")
    public void createCarsWithNameArrayTest(){
        // when
        String[] playerList = {"s","m","t"};
        Ready ready = new Ready();

        // given
        List<Car> cars = ready.createCars(playerList);

        // then
        assertThat(cars).hasSize(3);
    }
}
