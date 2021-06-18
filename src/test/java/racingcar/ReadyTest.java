package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadyTest {
    private final Ready ready = new Ready();

    @Test
    @DisplayName("이름 배열을 이용해서 자동차 목록 만들기 테스트")
    public void createCarsWithNameArrayTest(){
        // when
        String[] playerList = {"s","m","t"};

        // given
        List<Car> cars = ready.createCars(playerList);

        // then
        assertThat(cars).hasSize(3);
    }

    @Test
    @DisplayName("input 이용해서 자동차 목록 만들기 테스트")
    public void createCarsWithInputTest(){
        // when
        String input = "s,m,t,j";

        // given
        List<Car> cars = ready.createCars(input);

        // then
        assertThat(cars).hasSize(4);
    }
}
