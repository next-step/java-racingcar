package RacingCar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarRunnableTest {
    public final int ID = 0;
    public final int COUNT = 1;

    public Car car = new Car(ID);
    public RacingCarRunnable racingCarRunnable = new RacingCarRunnable(car, COUNT);

    @Test
    void 랜덤_수_구하기() {
        int randomNum = racingCarRunnable.getRandomNumber();
        assertThat(randomNum).isGreaterThan(-1);
        assertThat(randomNum).isLessThan(10);
    }

    @ParameterizedTest
    @CsvSource({"4,true","3,false"})
    void 자동차_이동_가능_여부_확인(int num, boolean expected) {
        assertThat(racingCarRunnable.isRunnable(num)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"3,0","4,1"})
    void 자동차_달리기(int randomNum, int expected) {
        assertThat(racingCarRunnable.runOrStop(randomNum)).isEqualTo(expected);
    }
}
