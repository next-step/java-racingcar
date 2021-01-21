package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

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

    @DisplayName("comma를 포함한 자동차 이름들을 인자로 받아 리스트 형태로 출력")
    @Test
    void getCarNames() {
        // given
        String inputString = "abc,def,ghi";
        provideInput(inputString);

        // when
        List<String> carNames = input.getCarNames();

        // then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        assertThat(carNames.get(0)).isEqualTo("abc");
        assertThat(carNames.get(1)).isEqualTo("def");
        assertThat(carNames.get(2)).isEqualTo("ghi");
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
