package carracing.model.race;

import carracing.model.car.RaceRecordOfCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceResultTest {
    @Nested
    @DisplayName("winner() 테스트")
    class WinnerTest {
        @Test
        @DisplayName("recordOfCarList가 빈 리스트라면 NoSuchElementException을 발생시킨다.")
        void testEmptyRaceRecordCase() {
            List<RaceRecordOfCar> recordOfCarList = Collections.emptyList();
            RaceResult raceResult = RaceResult.newResult(recordOfCarList);

            assertThatThrownBy(raceResult::winner)
                    .isExactlyInstanceOf(NoSuchElementException.class);
        }

        @Test
        @DisplayName("우승자가 한명인 경우")
        void testOneWinnerCase() {
            List<RaceRecordOfCar> recordOfCarList = Arrays.asList(
                    RaceRecordOfCar.newRaceRecord("a", 3, Arrays.asList(1, 2, 3)),
                    RaceRecordOfCar.newRaceRecord("b", 2, Arrays.asList(1, 1, 2)),
                    RaceRecordOfCar.newRaceRecord("c", 2, Arrays.asList(1, 1, 2))
            );
            RaceResult raceResult = RaceResult.newResult(recordOfCarList);

            assertThat(raceResult.winner()).isEqualTo("a");
        }

        @Test
        @DisplayName("우승자가 다수인 경우")
        void testSeveralWinnerCase() {
            List<RaceRecordOfCar> recordOfCarList = Arrays.asList(
                    RaceRecordOfCar.newRaceRecord("a", 3, Arrays.asList(1, 2, 3)),
                    RaceRecordOfCar.newRaceRecord("b", 3, Arrays.asList(1, 2, 3)),
                    RaceRecordOfCar.newRaceRecord("c", 3, Arrays.asList(1, 3, 3)),
                    RaceRecordOfCar.newRaceRecord("d", 1, Arrays.asList(1, 1, 1))
            );
            RaceResult raceResult = RaceResult.newResult(recordOfCarList);

            assertThat(raceResult.winner()).isEqualTo("a, b, c");
        }
    }
}