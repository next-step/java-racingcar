package calculator;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력기 테스트")
class InputTest {
    private static final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private static final PrintStream sysOut = System.out;

    @BeforeAll
    public static void setupAll() {
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void teardown() {
        testOut.reset();
    }

    @AfterAll
    public static void teardownAll() {
        System.setOut(sysOut);
    }

    @DisplayName("입력을 잘 받고 안내 메세지를 잘 출력하는지 확인")
    @Test
    void input() {
        Input input = new Input(
            new Scanner("in")
        );

        String result = input.input("out");

        assertThat(result).isEqualTo("in");
        assertThat(testOut.toString()).isEqualTo("out");
    }

}