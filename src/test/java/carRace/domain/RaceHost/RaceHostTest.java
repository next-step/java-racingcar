package carRace.domain.RaceHost;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import carRace.domain.car.Car;
import carRace.domain.car.CarGroups;
import carRace.domain.car.CarName;
import carRace.domain.car.CarNames;
import carRace.domain.randomNumber.RandomNumber;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceHostTest {

    @Test
    @DisplayName("경주가 끝난 자동차가 전달받은 랜덤번호가 4보다 큰 경우의 개수와 경주 기록이 똑같아야 한다.")
    public void Car_History_Length_And_Game_Record_Length_Should_Be_Same() throws Exception {
        //given
        int raceTryNumber = 1000;
        RaceHost raceHost = new RaceHost(raceTryNumber);
        CarGroups carGroups = new CarGroups(new CarNames(asList(new CarName("namhyeop"))));

        //when
        raceHost.playGame(carGroups);
        Car raceFinishedCar = carGroups.getCarGroups().stream()
            .findAny()
            .get();

        //자동차에 발급받은 랜덤 번호중에서 4보다 큰 경우의 개수와 경주 기록 길이가 같아야 한다.
        int moveDistance = raceFinishedCar
            .getMoveDistance()
            .getMoveDistance();

        int sumOfNumbersGreaterFour = (int) raceFinishedCar
            .getRandomNumberHistory()
            .getRandomNumbers()
            .stream()
            .mapToInt(RandomNumber::getRandomNumber)
            .filter(randomNumber -> randomNumber >= 4)
            .count();

        //then
        assertThat(moveDistance).isEqualTo(sumOfNumbersGreaterFour);
    }
}
