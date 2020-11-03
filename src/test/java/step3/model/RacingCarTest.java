package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("차량 전진 테스트")
    @Test
    public void racingCarAddCommand() {
        //Given
        RacingCar racingCar = new RacingCar(new RandomCommander());

        //When
        racingCar.executeMoveTrack();

        //Then
        assertThat(racingCar.getMoveTrack()).isGreaterThan(0);
    }


}
