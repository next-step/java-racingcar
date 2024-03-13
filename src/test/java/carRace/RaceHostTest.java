package carRace;

import static org.junit.jupiter.api.Assertions.*;

import carRace.domain.Car;
import carRace.domain.RaceHost;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceHostTest {

    @Test
    @DisplayName("경주가 끝난 자동차가 전달받은 랜덤번호가 4보다 큰 경우의 개수와 경주 기록이 똑같아야 한다.")
    public void Car_History_Length_And_Game_Record_Length_Should_Be_Same() throws Exception {
        //given
        int carMount = 100;
        int raceTryNumber = 1000;

        RaceHost raceHost = new RaceHost(carMount, raceTryNumber);
        List<Car> cars = Car.createCars(carMount);
        //when
        raceHost.playGame(cars);

        //각 자동차에 발급받은 랜덤 번호중에서 4보다 큰 경우의 개수와 경주 기록 길이가 같아야 한다.
        boolean allCarsHaveMatchResults = cars.stream().allMatch(car -> {
            long historyLength = car.randomNumberHistory()
                .stream()
                .filter(randomNumber -> randomNumber >= 4).count();
            int raceResultLength = car.moveCount();
            return historyLength == raceResultLength;
        });

        //then
        assertTrue(allCarsHaveMatchResults);
    }
}
