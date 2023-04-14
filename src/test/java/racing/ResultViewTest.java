package racing;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    private static final String LINE_BREAK = "\n";
    private static final String MARK = "=3";

    @Test
    void 자동차의_상태를_출력() {
        // 수정
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Cars cars = new Cars(3, 5);
        ResultView.print(cars.move());

        String expectedString = "Car 1 : " + MARK.repeat(cars.values().get(0).position()) + LINE_BREAK + "Car 2 : " + MARK.repeat(cars.values().get(1).position()) + LINE_BREAK + "Car 3 : " + MARK.repeat(cars.values().get(2).position()) + LINE_BREAK;
        assertThat(outputStream).hasToString(expectedString);

        System.setOut(System.out);
    }

}
