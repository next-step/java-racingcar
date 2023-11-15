package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WinnersTest {
    @Test
    @DisplayName("우승자 찾기")
    void findWinners() {
        // given
        Car toby = new Car("toby", 10);
        Car kim = new Car("kim", 1);
        Car kang = new Car("kang", 3);
        List<Car> cars = Arrays.asList(toby, kim, kang);
        // when
        Winners winners = new Winners();
        List<String> winnerCars = winners.findWinners(cars);
        // then
        Assertions.assertThat(winnerCars).hasSize(1);
        Assertions.assertThat(winnerCars).contains("toby");
    }
}
