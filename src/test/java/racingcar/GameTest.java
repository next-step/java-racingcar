package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GameTest {
    @BeforeEach
    void init() {
        String input = "3 10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("자동차 3대, 움직임 10번일때 게임 실행")
    @Test
    public void playGame() {
        Game game = new Game(0); // 테스트 결과 고정하기 위해 seed 지정
        game.racingCars();
    }
}
