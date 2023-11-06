package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

abstract class IOTest {
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DisplayName("System.in 테스트")
    @Test
    void system_in_success() {
        // given
        final String testString = "유저 입력 테스트";
        // when
        systemIn(testString);
        Scanner scanner = new Scanner(System.in);

        // then
        assertThat(scanner.nextLine()).isEqualTo(testString);
    }
}
