package logictest;

import logic.CarRacing;
import logic.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

    @Test
    @DisplayName("자동차 경주 1회 실행")
    void 자동차_경주_1회_실행 () {

        Cars cars = new Cars("pobi,jonga");
        CarRacing carRacing = new CarRacing(cars);
        //carRacing.runRace(5);
    }

}
