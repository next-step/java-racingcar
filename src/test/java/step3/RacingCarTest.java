package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("getRandomValue의 결과값 확인하기")
    void getRandomValueTest() {
        InputDto inputDto = new InputDto(3, 4);

        RacingCar racingCar = new RacingCar();
        racingCar.setInput(inputDto);

        int[][] result = racingCar.getRandomValue();

        assertThat(result.length).isEqualTo(4);
        assertThat(result[0].length).isEqualTo(3);
        assertThat(result[1].length).isEqualTo(3);
        assertThat(result[2].length).isEqualTo(3);
    }

}