package woowacamp.racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ValueSource(ints = {4, 9})
    @ParameterizedTest
    void 모든_자동차가_움직인다(int number) {
        // given
        Cars cars = new Cars("충환,정규,충규");

        // when
        cars.move(() -> number);

        // then
        List<Position> positions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        assertThat(positions)
                .containsExactly(new Position(1), new Position(1), new Position(1));
    }

    @ValueSource(ints = {0, 3})
    @ParameterizedTest
    void 모든_자동차가_움직이지_않는다(int number) {
        // given
        Cars cars = new Cars("충환,정규,충규");

        // when
        cars.move(() -> number);

        // then
        List<Position> positions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        assertThat(positions)
                .containsExactly(new Position(0), new Position(0), new Position(0));
    }

    @Test
    void 우승자를_구한다() {
        // given
        Cars cars = new Cars(
                List.of(new Car("충환", 3),
                        new Car("정규", 3),
                        new Car("충규", 1)));

        // when
        List<String> winnerNames = cars.winners()
                .stream()
                .map(Car::getName)
                .map(Name::getValue)
                .collect(Collectors.toList());

        // then
        assertThat(winnerNames).containsExactly("충환", "정규");
    }

    @Test
    void 자동차가_두_대_미만이면_예외가_발생한다() {
        List<Car> cars = List.of(new Car("충규"));

        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
