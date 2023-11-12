package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarFactory;

class CarFactoryTest {

    @Test
    @DisplayName("입력한 CarName의 수 만큼 게임에 참여할 자동차가 생성되어야 한다.")
    void testCreateCars() {
        List<String> carNames = List.of("a6","amg43","g70","m320i");
        assertThat(CarFactory.createCars(carNames)).hasSize(4);
    }
}
