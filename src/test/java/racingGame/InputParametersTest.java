package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.exception.NegativeExceptionV1;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameInputTest {
    private Scanner scanner;

    @Test
    @DisplayName("음수를 입력시 IllegalArgumentException을 던진다.")
    void if_input_negative_throw_exception() {
        String carNum = "1";
        String tryNum = "-1";
        assertThrows(NegativeExceptionV1.class, () -> {
            new InputParameters(carNum, tryNum);
        });
    }


}