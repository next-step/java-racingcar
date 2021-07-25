package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("경주용 자동차 테스트")
public class RacingCarTest {

    @DisplayName("자동차가 4 이상의 값을 부여받으면 한 칸 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "3:0", "4:1", "6:1", "7:1", "9:1"}, delimiter = ':')
    public void moveOrStopTest(int value, int position) {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        racingCar.moveOrStop(value);

        // then
        assertEquals(racingCar.getPosition(), position);
    }
}
