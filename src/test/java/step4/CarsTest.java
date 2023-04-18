package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("Cars.move() 호출 시 Car position 변경 테스트")
    @Test
    void carPositionWhenMoveCalled() {
        Cars cars = Cars.of(() -> 5, List.of("t1", "t2", "t3"));
        cars.move();
        List<Integer> positions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
        assertThat(positions)
                .hasSize(3)
                .allMatch(Predicate.isEqual(1));
    }
}
