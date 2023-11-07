package racing.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGeneratorTest {
    @Test
    @DisplayName("[CarGenerator.createMultipleCars] 3개 생성 요청 시 -> Car 객체가 딱 3개 담긴 리스트 반환")
    public void createMultipleCarsTest() {
        assertThat(CarGenerator.createMultipleDefaultCars(3))
                .hasSize(3);
    }
}
