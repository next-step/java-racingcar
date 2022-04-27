package study.step4.try1.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    @Test
    void 우승자_찾기() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 3));
        cars.add(new Car("java", 2));
        cars.add(new Car("jigi", 1));
        assertThat(Winner.findWinners(cars).trim().replaceAll(",$", "")).isEqualTo("pobi");
    }
}