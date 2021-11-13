package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

public class GameTest {
    @BeforeEach
    void init() {
        String input = "3 10";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("자동차 3대, 움직임 10번일때 게임 실행")
    @Test
    public void oneGame() {
        Game game = new Game();
        game.racingCar();
    }
}
