package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarControllerTest {

    @Test
    @DisplayName("차를 한대 등록하여 한칸 전진 시킨다.")
    public void moveForward() {
        // given
//        RacingCarController racingCarController
//                = new RacingCarController(new InputView().createRacingCars(1));
        RacingCar racingCar = new RacingCar();
        RacingCarController racingCarController = new RacingCarController(null);
        // when & then
        assertThat(racingCarController.moveForward(racingCar)).isLessThanOrEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,false", "4,true", "9,true", "0,false"})
    @DisplayName("입력 값을 받아서 뺄셈을 수행하여 값을 리턴 받음")
    public void isMovable(String input, String expected) {
        // given
        RacingCar racingCar = new RacingCar();
        RacingCarController racingCarController = new RacingCarController(null);

        // when & then
        assertThat(racingCarController.isMovable(Integer.parseInt(input)))
                .isEqualTo(Boolean.parseBoolean(expected));
    }
}
