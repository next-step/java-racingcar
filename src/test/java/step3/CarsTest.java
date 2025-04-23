package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @DisplayName("입력한 자동차 개수만큼 Car 객체가 생성된다")
    @Test
    void createCar() {
        int carCount = 3;
        Cars cars = new Cars(carCount);

        List<Position> positions = cars.move();
        assertThat(positions.size()).isEqualTo(carCount);
    }

    @DisplayName("자동차 이동 후 결과(Position)가 생성된다")
    @Test
    void createPosition() {
        Cars cars = new Cars(3);
        List<Position> positions = cars.move();

        assertThat(positions).doesNotContainNull();
    }
}