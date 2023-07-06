package woowacamp.racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    void 자동차_이름_목록으로_여러_자동차를_생성한다() {
        String value = "충환,정규,충규";

        Cars cars = new Cars(value);

        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 모든_자동차를_움직인다() {
        Cars cars = new Cars("충환,정규,충규");

        cars.move(() -> 3);

        List<Position> positions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        assertThat(positions)
                .containsExactly(new Position(3), new Position(3), new Position(3));
    }

    @Test
    void 우승자를_구한다() {
        Cars cars = new Cars(
                List.of(new Car("충환", 3),
                        new Car("정규", 3),
                        new Car("충규", 1)));

        List<String> winnerNames = cars.winners()
                .stream()
                .map(Car::getName)
                .map(Name::getValue)
                .collect(Collectors.toList());

        assertThat(winnerNames).containsExactly("충환", "정규");
    }

    @Test
    void 자동차가_두_대_미만이면_예외가_발생한다() {
        List<Car> cars = List.of(new Car("충규"));

        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
