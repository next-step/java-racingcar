package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
public class RacingCarTest {

    RacingCar racingCar = new RacingCar();


    @Test
    @DisplayName("사용자에게 특정 메세지를 보여주는 기능")
    void showMessage() {
        assertThat(racingCar.questionMessage("TRY")).isEqualTo("시도할 회수는 몇 회 인가요?");
        assertThat(racingCar.questionMessage("CAR")).isEqualTo("자동차 대수는 몇 대 인가요?");
        assertThat(racingCar.questionMessage("A")).isEqualTo("NO MESSAGE");
    }

    @Test
    @DisplayName("사용자에게 숫자만 입력받는 기능")
    void systemSetInNumber() {
        InputStream inputStream = new ByteArrayInputStream("3".getBytes());
        System.setIn(inputStream);
        int result = racingCar.scanNumber();
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("0에서 9사이의 random값을 구한 후 4이상일 경우 전진하는 기능")
    void forwardAndStop() {
        Random random = new Random();
        int number = random.nextInt(10);

        String result = "";
        if(number >= 4) {
            result = "FORWARD";
        }else {
            result = "STOP";
        }

        if(number >= 4) {
            assertThat(result).isEqualTo("FORWARD");
        }else {
            assertThat(result).isEqualTo("STOP");
        }

    }
}
