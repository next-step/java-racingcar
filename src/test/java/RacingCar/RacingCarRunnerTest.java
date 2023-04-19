package RacingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

public class RacingCarRunnerTest {
    public RacingCarRunner racingCarRunner = new RacingCarRunner();
    @Test
    void 랜덤_수_구하기() {
        int randomNum = racingCarRunner.getRandomNumber();
        assertThat(randomNum).isGreaterThan(-1);
        assertThat(randomNum).isLessThan(10);
    }

    @ParameterizedTest
    @CsvSource({"4,true","3,false"})
    void 자동차_이동_가능_여부_확인(int num, boolean expected) {
        assertThat(racingCarRunner.isRunnable(num)).isEqualTo(expected);
    }

    @Test
    void 사용자_입력_받기() {
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        assertThat(racingCarRunner.getUserInput()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource({"3,0","4,1"})
    void 자동차_달리기(int randomNum, int expected) {
        assertThat(racingCarRunner.runOrStop(randomNum)).isEqualTo(expected);
    }
}
