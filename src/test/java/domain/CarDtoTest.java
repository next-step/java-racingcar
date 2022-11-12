package domain;

import static org.assertj.core.api.Assertions.assertThat;

import dto.CarDto;
import org.junit.jupiter.api.Test;

public class CarDtoTest {

    private static final String RESULT_SEPARATOR = " : ";
    private static final String POSITION_INDICATOR = "-";

    @Test
    void checkResultString() {
        String carName = "gglee";
        int position = 5;

        CarDto carDto = new CarDto(carName, position);
        assertThat(carDto.getResultString()).isEqualTo(carName + RESULT_SEPARATOR + POSITION_INDICATOR.repeat(position));
    }
}
