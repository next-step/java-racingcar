package step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car mockCar;

    @BeforeEach
    void setUp() {
        mockCar = new Car("car1");
    }

    @Test
    @DisplayName("자동차가 한 칸 전진하는데 성공")
    void isMovableSuccess() {
        mockCar.move(4);
        assertThat(mockCar.getPosition())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 한 칸 전진하는데 실패")
    void isMovableFail() {
        mockCar.move(3);
        assertThat(mockCar.getPosition())
                .isEqualTo(0);
    }

}
