package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {
    @Test
    @DisplayName("레이싱 경기 우승자를 찾습니다")
    void 레이싱_경기_우승자_찾기() {
        Car a = new Car("a",3);
        Car b = new Car("b",4);
        Car c = new Car("c",4);

        List<Car> cars = Arrays.asList(a,b,c);

        List<Car> winners = Winners.findWinners(cars);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).isEqualTo(List.of(b,c));
    }
}