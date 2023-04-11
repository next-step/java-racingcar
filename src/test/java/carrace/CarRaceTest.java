package carrace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceTest {
    
    @Test
    @DisplayName("자동차 경주 게임을 시작할 수 있다.")
    void carTest() {
        final int numberOfLaps = 5;
        final int numberOfCars = 5;
        final Cars cars = new Cars(numberOfCars);
        final CarRace carRace = new CarRace(cars, numberOfLaps);
        carRace.start();
    }

}
