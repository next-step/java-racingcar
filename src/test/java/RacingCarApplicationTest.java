import core.TestObjectGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarApplicationTest {
    private final PrintStream systemOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(systemOut);
    }

    @Test
    @DisplayName("자동차 이름과 이동횟수를 입력받고 우승자를 출력해야 한다")
    void main() {
        //given
        final String carName = "a";
        final String moveCount = "5";
        String input = String.join("\n", Arrays.asList(carName, moveCount));
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        RacingCarApplication.main(null);

        //then
        assertThat(outputStream.toString()).contains("a가 최종 우승했습니다.");
    }
}