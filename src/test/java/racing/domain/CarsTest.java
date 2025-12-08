package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private final List<CarName> carNames = List.of(
            new CarName("자동차1"), new CarName("자동차2"), new CarName("자동차3")
    );

    @Test
    void 경주할_자동차의_개수가_1일_때_예외가_발생한다() {
        List<CarName> onlyOneCarName = List.of(new CarName("자동차"));

        assertThatThrownBy(() -> new Cars(onlyOneCarName))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 경주를 진행하기 위해서는 두 대 이상의 자동차가 필요합니다.");
    }

    @Test
    void 입력한_자동차의_대수만큼_자동차가_생성된다() {
        Cars cars = new Cars(carNames);

        assertThat(cars.size()).isEqualTo(carNames.size());
    }

    @Test
    void 모든_자동차들이_이동한다() {
        Cars cars = new Cars(carNames);
        cars.moveCars(() -> true);

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void 여러번_이동한_후_현재_위치를_반영한다() {
        Cars cars = new Cars(carNames);

        cars.moveCars(() -> true);
        cars.moveCars(() -> true);

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(2);
        }
    }
}
