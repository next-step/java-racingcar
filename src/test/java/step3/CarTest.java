package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setup() {
        this.car = new Car(1);
    }

    @ParameterizedTest
    @CsvSource(value= {"true:1", "false:0"}, delimiter = ':')
    void attemptGoing(boolean goingPossibility, Integer result) {
        Integer beforeDistance = this.car.getDistance();
        Integer afterDistance = car.attemptGoing(goingPossibility);
        assertThat(afterDistance - beforeDistance).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value= {"1:false", "2:false", "3:false", "4:true", "5:true", "9:true"}, delimiter = ':')
    void isAbleToGo(Integer score, boolean result) {
        assertThat(car.isAbleToGo(score)).isEqualTo(result);
    }

    @DisplayName("10만번 random 값을 뽑는 것 모두 0-9 사이의 값이어야 한다.")
    @Test
    void rollDice() {
        Integer givenStart = 0;
        Integer givenEnd = 100000;

        IntStream.range(givenStart,givenEnd).forEach(index -> assertThat(car.rollDice()).isBetween(0,9));
    }

}