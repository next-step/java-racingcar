package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingSessionTest {

    @Test
    @DisplayName("입력받은 수만큼 턴 행동")
    void 턴_행동() {
        RacingSession session = RacingSession.of("a,b");

        List<CarPositions> positions = session.startRacing(5);

        assertThat(positions).hasSize(5);
        for (CarPositions position : positions) {
            assertThat(position.getCarPositions()).hasSize(2);
        }
    }

    @Test
    @DisplayName("각 자동차 이동")
    void 자동차_이동() {
        List<Car> cars = List.of(Car.of("a"), Car.of("b"), Car.of("c"));

        CarPositions positions = RacingSession.moveCars(cars);

        assertThat(positions.getCarPositions()).hasSize(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true",
            "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void 전진_조건(int number, boolean canMove) {
        assertThat(RacingSession.canProgress(number)).isEqualTo(canMove);
    }


}
