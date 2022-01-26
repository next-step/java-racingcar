package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {
    @DisplayName("우승자 잘 뽑히는지 확인")
    @Test
    void 우승자_확인() {
        List<Car> cars = new ArrayList<>();
        List<String> names = Arrays.asList("p1", "p2", "p3");
        for (String name : names) {
            cars.add(Car.of(name));
        }
        cars.get(0).moveForward();

        List<String> winners = Winner.findWinner(cars);
        Assertions.assertThat(winners.get(0)).isEqualTo("p1");
    }
}