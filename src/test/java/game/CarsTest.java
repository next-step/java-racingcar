package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;

class CarsTest {

    @DisplayName("전진하는 전략일 때는 1칸 전진한다")
    @Test
    void race_1() {
        // given
        Cars cars = new Cars(new CarNames(List.of(new CarName("a"), new CarName("b"), new CarName("c"))));
        // when
        cars.race(() -> 4);
        // then
        Assertions.assertThat(cars.positionByName())
                .containsExactly(new AbstractMap.SimpleEntry<>("a", 1), new AbstractMap.SimpleEntry<>("b", 1), new AbstractMap.SimpleEntry<>("c", 1));
    }

    @DisplayName("정지하는 전략일 때는 전진하지 않는다")
    @Test
    void race_2() {
        // given
        Cars cars = new Cars(new CarNames(List.of(new CarName("a"), new CarName("b"), new CarName("c"))));
        // when
        cars.race(() -> 3);
        // then
        Assertions.assertThat(cars.positionByName())
                .containsExactly(new AbstractMap.SimpleEntry<>("a", 0), new AbstractMap.SimpleEntry<>("b", 0), new AbstractMap.SimpleEntry<>("c", 0));
    }
}
