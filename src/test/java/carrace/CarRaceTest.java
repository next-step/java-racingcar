package carrace;

import carrace.util.RandomNumberGenerator;
import carrace.util.Splitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {

    @Test
    @DisplayName("0에서 9사이 int값 반환")
    void isBetweenZeroAndNine() {
        assertThat(new RandomNumberGenerator().getRandomBetweenZeroAndNine()).isBetween(0, 9);
    }

    @ParameterizedTest
    @DisplayName("입력받은 값을 기준으로 계산된 raceInfoBoard 체크")
    @CsvSource(value = {"jess,apollo:5", "jess,apollo,kim:1"}, delimiter = ':')
    void checkRaceInfoBoard(String carNames, int numberOfRaces) {
        CarRace carRace = new CarRace(carNames, numberOfRaces);
//        carRace.startRacee();

        assertThat(carRace.getRecordCarRace().getRaceInfoBoards().size())
                .isEqualTo(numberOfRaces * carRace.getNumberOfCars());
        assertThat(carRace.getRecordCarRace().getRaceInfoBoards().get(0))
                .isBetween(0, numberOfRaces);
    }

//    @Test
//    @DisplayName("우승자 확인")
//    void checkWinners() {
//        RaceWinner raceWinner = new RaceWinner(3);
//        List<Integer> raceInfoBoards = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 2, 2, 2, 1, 1, 1));
//        String carNames = "jess,apollo,kim";
//        List<Car> cars = new Splitter().splitCarNames(carNames);
//
//        raceWinner.confirmWinners(raceInfoBoards, cars);
//
//        assertThat(raceWinner.getWinners().size()).isEqualTo(1);
//        assertThat(raceWinner.getWinners().get(0).getName()).isEqualTo("kim");
//    }

}
