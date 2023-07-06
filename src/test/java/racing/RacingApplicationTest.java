package racing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.exception.IllegalCarNameException;
import racing.exception.IllegalCountException;
import racing.generator.SpecificNumberGenerator;
import racing.input.RacingInput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingApplicationTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void runTest() {
        String inputString = "pobi,crong,honux\n5";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
        RacingApplication application = new RacingApplication(new RacingInput(inputStream), new SpecificNumberGenerator(9));
        application.run();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n" +
                "시도할 회수는 몇회인가요?\n" +
                "\n" +
                "실행 결과\n" +
                "pobi : -\n" +
                "crong : -\n" +
                "honux : -\n" +
                "\n" +
                "pobi : --\n" +
                "crong : --\n" +
                "honux : --\n" +
                "\n" +
                "pobi : ---\n" +
                "crong : ---\n" +
                "honux : ---\n" +
                "\n" +
                "pobi : ----\n" +
                "crong : ----\n" +
                "honux : ----\n" +
                "\n" +
                "pobi : -----\n" +
                "crong : -----\n" +
                "honux : -----\n" +
                "\n" +
                "pobi : ------\n" +
                "crong : ------\n" +
                "honux : ------\n" +
                "\n" +
                "pobi, crong, honux가 최종 우승했습니다.");
    }

    @Test
    void runFailWithLongCarNameTest() {
        String inputString = "pobias,crong,honux\n5";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
        RacingApplication application = new RacingApplication(new RacingInput(inputStream), new SpecificNumberGenerator(9));
        assertThrows(IllegalCarNameException.class, application::run);
    }

    @Test
    void runFailWithNoCarNameTest() {
        String inputString = ",crong,honux\n5";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
        RacingApplication application = new RacingApplication(new RacingInput(inputStream), new SpecificNumberGenerator(9));
        assertThrows(IllegalCarNameException.class, application::run);
    }

    @Test
    void runFailWithNotNumberTest() {
        String inputString = "pobi,crong,honux\na";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
        RacingApplication application = new RacingApplication(new RacingInput(inputStream), new SpecificNumberGenerator(9));
        assertThrows(IllegalCountException.class, application::run);
    }
}
