package study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.Car;
import study.domain.Winner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerTest {

    @Test
    @DisplayName("우승자 조회")
    void findWinnerTest(){
        //given
        Car car1 = new Car("a", 1);
        Car car2 = new Car("b", 2);
        List<Car> carList = Arrays.asList(car1, car2);
        Winner winner = new Winner(carList);
        //when
        List<Car> winners = winner.findWinner();
        //then
        assertThat(winners.contains(car2));
    }
}
