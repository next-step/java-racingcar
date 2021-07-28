package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarStatusTest {

    @Test
    @DisplayName("CarStatus 생성 테스트")
    public void createCarStatus() {
        // given
        String name = "iiaii";
        int position = 1;
        CarStatus carStatus = new CarStatus(new CarName(name), position);
        String expectedName = "iiaii";
        int expectedPosition = 1;

        // when


        // then
        assertThat(carStatus.getName()).isEqualTo(expectedName);
        assertThat(carStatus.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("name 가져오기")
    public void getName() {
        // given
        String name = "iiaii";
        int position = 1;
        CarStatus carStatus = new CarStatus(new CarName(name), position);
        String expectedName = "iiaii";

        // when
        String result = carStatus.getName();

        // then
        assertThat(result).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("position 가져오기")
    public void getPosition() {
        // given
        String name = "iiaii";
        int position = 1;
        CarStatus carStatus = new CarStatus(new CarName(name), position);
        int expectedPosition = 1;

        // when
        int result = carStatus.getPosition();

        // then
        assertThat(result).isEqualTo(expectedPosition);
    }

    @ParameterizedTest(name = "position 비교 | {arguments}")
    @CsvSource(value = {"2:2:true", "3:1:false", "4:5:false"}, delimiter = ':')
    public void isEqualToPosition(int position, int equalToPosition, boolean expected) {
        // given
        String name = "iiaii";
        CarStatus carStatus = new CarStatus(new CarName(name), position);

        // when
        boolean result = carStatus.isEqualToPosition(equalToPosition);

        // then
        assertThat(result).isEqualTo(expected);
    }

}