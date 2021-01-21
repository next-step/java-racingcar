package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class KeyboardInputTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private Input input;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("문자열을 잘 입력 받는지 확인한다")
    @Test
    void getCarNames() {
        // given
        String inputString = "123";
        provideInput(inputString);

        // when
        String result = input.getCarNames();

        // then
        assertThat(result).isEqualTo(inputString);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    @DisplayName("숫자를 잘 입력받는지 확인한다")
    @Test
    void getTryCount() {
        // given
        String inputString = "1";
        provideInput(inputString);

        // when
        int result = input.getTryCount();

        // then
        assertThat(result).isEqualTo(Integer.parseInt(inputString));
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("시도할 횟수는 몇 회인가요?");
    }

    private void provideInput(final String inputString) {
        input = new KeyboardInput(new ByteArrayInputStream(inputString.getBytes()));
    }
}
