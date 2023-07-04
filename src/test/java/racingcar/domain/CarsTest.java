package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("자동차 이름 목록으로 여러 자동차를 생성한다.")
    void test_01() {
        /* given */
        String value = "충환,정규,충규";

        /* when */
        Cars cars = new Cars(value);

        /* then */
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("모든 자동차를 움직인다.")
    void test_02() {
        /* given */
        Cars cars = new Cars("충환,정규,충규");

        /* when */
        cars.move(() -> 3);

        /* then */
        List<Position> positions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        assertThat(positions).containsExactly(new Position(3), new Position(3), new Position(3));
    }
}
