package racing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("경기 정보 받는 테스트")
    void racingGameInfo() {
        int car = 5;
        int cycle = 10;
        RacingGame game = new RacingGame(car, cycle);
        game.info();
        assertThat(outContent.toString().trim()).isEqualTo("자동차 수: " + car + ", 사이클 수: " + cycle);
    }

    @Test
    @DisplayName("경기에서 자동차 수, 시도 횟수 입력받기")
    void racingGameInput() {
        int car = 5;
        int cycle = 10;
        mockInput(car + "\n" + cycle);
        RacingGame game = new RacingGame();
        game.info();
        assertThat(outContent.toString().trim()).isEqualTo("자동차 수: " + car + ", 사이클 수: " + cycle);
    }

    private static void mockInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}