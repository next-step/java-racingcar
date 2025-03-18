package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarGeneratorTest {

    @Test
    @DisplayName("입력한 숫자만큼 차량 객체를 생성하고, 초기 위치는 0이다.")
    void createCars() {
        assertThat(CarGenerator.createCars(3))
                .hasSize(3)
                .allMatch(car -> car.isAtPosition(new Position(0)));
    }
}
