package carrace;

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
    @DisplayName("DECISION_VALUE(4) 이상의 number를 입력받을 때에만 GO(1) 리턴")
    void getOneIfMoreThanDecisionValue() {
        CarRace carRace = new CarRace();
        assertThat(carRace.goIfMoreThanDecisionValue()).isIn(CarRaceRule.STOP.getValue(), CarRaceRule.GO.getValue());
    }

    @ParameterizedTest
    @DisplayName("입력받은 값을 기준으로 계산된 raceInfoBoard 체크")
    @CsvSource(value = {"3:5", "2:1"}, delimiter = ':')
    void checkRaceInfoBoard(int numberOfCars, int numberOfRaces) {
        CarRace carRace = new CarRace(numberOfCars, numberOfRaces);
        carRace.startRaces();

        assertThat(carRace.getRaceInfoBoards().size()).isEqualTo(numberOfRaces * numberOfCars);
        assertThat(carRace.getRaceInfoBoards().get(0)).isBetween(0, numberOfRaces);
    }

}
