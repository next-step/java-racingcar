package carRacing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    public void create() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차가 기본 거리 0을 기준으로 생성되는지 확인")
    void 자동차_생성() {
        assertThat(car.getDistanceForPrint()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동자가 전진하는지 확인")
    void 자동차_전진() {
        car.move();

        assertThat(car.getDistanceForPrint()).isEqualTo(1);
    }
}
