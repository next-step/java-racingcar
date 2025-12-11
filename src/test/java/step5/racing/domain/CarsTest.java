package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private final List<CarName> carNames = List.of(
            new CarName("자동차1"), new CarName("자동차2"), new CarName("자동차3")
    );

    @Test
    void 자동차가_한_대만_존재하면_예외가_발생한다() {
        List<CarName> carNames = List.of(new CarName("자동차1"));

        assertThatThrownBy(() -> new Cars(new CarNames(carNames)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_자동차의_대수만큼_자동차가_생성된다() {
        Cars cars = new Cars(new CarNames(carNames));

        assertThat(cars.size()).isEqualTo(carNames.size());
    }

    @Test
    void 자동차들이_이동한다() {
        Cars cars = new Cars(new CarNames(carNames));
        cars.move(() -> true);

        for (Car car : cars.getCars()) {
            assertThat(car.position()).isEqualTo(new Position(1));
        }
    }

    @Test
    void 자동차들이_여러번_이동한다() {
        Cars cars = new Cars(new CarNames(carNames));
        cars.move(() -> true);
        cars.move(() -> true);

        for (Car car : cars.getCars()) {
            assertThat(car.position()).isEqualTo(new Position(2));
        }
    }
}
