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
    @DisplayName("레이싱의 결과가 제대로 동작이 되었는가?")
    void startRacing(int carCount, int tryCount) {
        assertEquals(RunCarRace.testRun(carCount, tryCount), RunCarRace.testRun(carCount, tryCount));
    }

}
