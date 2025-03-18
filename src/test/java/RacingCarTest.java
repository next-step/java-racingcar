import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private final RacingCar racingCar = new RacingCar();
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    @DisplayName("자동차 대수와 시도할 회수를 순서대로 입력받는 안내문구를 출력하고 입력받는다.")
    public void test6() {
        System.setIn(new ByteArrayInputStream("3\n5\n".getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        racingCar.input();

        String expected = "자동차 대수는 몇 대 인가요?\n시도할 회수는 몇 회 인가요?\n\n";
        assertThat(out.toString().replace("\r\n", "\n")).isEqualTo(expected);
    }

    @RepeatedTest(value = 30)
    @DisplayName("0에서 9 사이 random 값을 생성한다.")
    public void test4() {
        assertThat(racingCar.createRandom()).isBetween(0, 9);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = { "0:false", "4:true", "9:true" })
    @DisplayName("random 값이 4 이상이면 전진하고, 그렇지 않으면 정지한다.")
    public void test5(int input, boolean expected) {
        assertThat(racingCar.isGoingForward(input)).isEqualTo(expected);
    }



}
