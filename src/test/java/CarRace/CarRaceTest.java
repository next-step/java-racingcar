package CarRace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {

    @Test
    @DisplayName("0에서 9사이 int값 반환")
    void isBetweenZeroAndNine() {
        assertThat(new CarRace().getRandomNumberBetweenZeroAndNine()).isBetween(0, 9);
    }

    @Test
    @DisplayName("4이상의 number를 입력받을 때에만 1 리턴")
    void getOneIfMoreThanFour() {
        CarRace carRace = new CarRace();
        assertThat(carRace.goIfMoreThanFour(4)).isEqualTo(1);
        assertThat(carRace.goIfMoreThanFour(8)).isEqualTo(1);
        assertThat(carRace.goIfMoreThanFour(1)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("입력받은 값을 기준으로 계산된 raceInfoBoard 체크")
    @CsvSource(value = {"3:5", "2:1"}, delimiter = ':')
    void checkRaceInfoBoard(int numberOfCars, int numberOfRaces) {
        CarRace carRace = new CarRace(numberOfCars, numberOfRaces);
        carRace.startRace();

        assertThat(carRace.raceInfoBoard.size()).isEqualTo(numberOfRaces);
        assertThat(carRace.raceInfoBoard.get(0).size()).isEqualTo(numberOfCars);
        assertThat(carRace.raceInfoBoard.get(0).get(0)).isBetween(0, numberOfRaces);
    }

}
