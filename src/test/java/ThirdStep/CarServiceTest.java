package ThirdStep;

import ThirdStep.domain.CarService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {

    @Test
    @DisplayName("전진 조건을 만족하면(true) 1를 반환한다.")
    void Car_이동_true() {
        assertThat(CarService.movedDistance(() -> true)).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건을 만족하지 못하면(false) 0을 반환한다.")
    void Car_이동_false() {
        assertThat(CarService.movedDistance(() -> false)).isEqualTo(0);
    }

}
