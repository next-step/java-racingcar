package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true", "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void movableTest(int number, boolean expected) {
        Car car = new Car("pobi");
        assertThat(car.movable(number)).isEqualTo(expected);
    }

    @Test
    void raceTest() {
        String[] carNames = {"pobi", "crong", "honux"};
        int tryCount = 5;
        Cars cars = new Cars(carNames);
        cars.race(tryCount);
        List<String> positionStrings = cars.getPositionStrings();

        for (String positionString : positionStrings) {
            assertTrue(isDashOnly(positionString));
            assertThat(positionString.length()).isBetween(0, tryCount);
        }
    }

    private boolean isDashOnly(String input) {
        return input.matches("^-*$");
    }

    @Test
    void carNameTest() {
        assertThatThrownBy(() -> new Car("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }
}
