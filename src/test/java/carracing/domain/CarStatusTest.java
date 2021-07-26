package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarStatusTest {

    @Test
    @DisplayName("CarStatus 생성 테스트")
    public void createCarStatus() {
        // given
        String name = "iiaii";
        int position = 1;
        CarStatus carStatus = new CarStatus(name, position);
        String expectedName = "iiaii";
        int expectedPosition = 1;

        // when


        // then
        assertThat(carStatus.getName()).isEqualTo(expectedName);
        assertThat(carStatus.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("CarStatus increasePosition 테스트")
    public void increasePosition() {
        // given
        String name = "iiaii";
        int position = 1;
        CarStatus carStatus = new CarStatus(name, position);
        String expectedName = "iiaii";
        int expectedPosition = 2;

        // when
        carStatus.increasePosition();

        // then
        assertThat(carStatus.getName()).isEqualTo(expectedName);
        assertThat(carStatus.getPosition()).isEqualTo(expectedPosition);
    }

}