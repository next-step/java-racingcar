package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car mockCar;

    @BeforeEach
    void setUp() {
        mockCar = new Car("testCar1");
    }

    @Test
    @DisplayName("자동차가 한 칸 전진하는데 성공")
    void isMovableSuccess() {
        boolean isMovable = true;
        mockCar.move(isMovable);
        assertThat(mockCar.getSteps()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 한 칸 전진하는데 실패")
    void isMovableFail() {
        boolean isMovable = false;
        mockCar.move(isMovable);
        assertThat(mockCar.getSteps()).isEqualTo(0);
    }

}
