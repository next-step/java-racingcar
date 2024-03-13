package carracing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    @Test
    @DisplayName("start(): 자동차 대수 크기의 List<RaceResultOfCar>를 멤버 변수로 가지고 있는 RaceResult를 반환한다.")
    void testStart() {
        List<NameOfCar> nameOfCarList = Arrays.asList(NameOfCar.newName("a"), NameOfCar.newName("b"));
        NumberOfAttempts numberOfAttempts = NumberOfAttempts.newNumber("5");

        Race race = Race.newRace(nameOfCarList, numberOfAttempts);
        RaceResult raceResult = race.start();

        assertThat(raceResult.recordOfCarList().size()).isEqualTo(nameOfCarList.size());
    }
}