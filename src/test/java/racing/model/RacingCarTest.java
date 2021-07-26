package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("경주용 자동차 테스트")
public class RacingCarTest {

    @DisplayName("자동차가 4 이상의 값을 부여받으면 한 칸 전진하고, 그렇지 않으면 멈춘다.")
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1", "5:1"}, delimiter = ':')
    public void moveOrStopTest(int number, int position) {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        racingCar.moveForwardOneStepOrStop(Number.valueOf(number));

        // then
        assertEquals(racingCar.getPosition(), position);
    }
}
