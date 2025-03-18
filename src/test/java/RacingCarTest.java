import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    private final RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("자동차 대수와 시도할 회수를 순서대로 입력받는 안내문구를 출력하고 입력받는다.")
    public void test6() {
        System.setIn(new ByteArrayInputStream("3\n5\n".getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        racingCar.input();

        String expected = "자동차 대수는 몇 대 인가요?\n시도할 회수는 몇 회 인가요?\n\n";
        assertThat(out.toString().replace("\r\n", "\n")).startsWith(expected);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"-3,0", "0,0", "3,-1"})
    @DisplayName("자동차 대수와 시도할 회수는 양수여야한다.")
    public void test9(int carNumber, int tryCount) {
        String in = String.format("%s%n%s%n", carNumber, tryCount);
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        assertThatThrownBy(racingCar::input)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진하거나 멈출 수 있으며, 횟수마다 실행 결과를 출력한다.")
    public void test7() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        racingCar.start(1, 2);
        String print = out.toString();
        assertThat(print).containsPattern("실행 결과\n?[-]\n\n?[-]");
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
