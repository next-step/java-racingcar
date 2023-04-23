package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
        Scanner scanner = new Scanner(System.in);
        String result = scanner.next();
        assertThat(result).isEqualTo("3");
    }
}
