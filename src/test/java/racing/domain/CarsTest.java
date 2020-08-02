package racing.domain;

import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("레이싱 게임을 위한 자동차가 입력받은 개수만큼 생성되는지 확인한다")
    @Test
    void makeCars() {
        Cars cars = new Cars(5);

        assertThat(cars.getNumberOfCars()).isEqualTo(5);
    }
}
