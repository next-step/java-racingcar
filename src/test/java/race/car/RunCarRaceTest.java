package race.car;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class RunCarRaceTest {

    @ParameterizedTest(name = "{index} => basePrice={0}, maxPrice={1}")
    @CsvSource({
            "1, 1",
            "10, 10",
            "5, 5"
    })
    @DisplayName("자동차가 갯수가 제대로 만들어졌는지?")
    void testCarCount(int carCount, int tryCount) {
        CarRaceInformation carRaceInformation = new CarRaceInformation(carCount, tryCount);

        assertTrue(carRaceInformation.getCarMoveCountArr().length <= carCount);
    }

    @ParameterizedTest(name = "{index} => basePrice={0}, maxPrice={1}")
    @CsvSource({
            "1, 1",
            "10, 10",
            "5, 5"
    })
    @DisplayName("자동차가 제대로 이동했는지?")
    void testTryCount(int carCount, int tryCount) {
        CarRaceInformation carRaceInformation = new CarRaceInformation(carCount, tryCount);

        for(int i=0; i<carRaceInformation.getCarMoveCountArr().length; i++){
            assertTrue(carRaceInformation.getCarMoveCountArr()[i] <= tryCount);
        }
    }
}
