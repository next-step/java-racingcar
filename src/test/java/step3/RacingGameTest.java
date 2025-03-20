package step3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

// 질문:
// - 어떤 메소드를 테스트로 작성해야 하는가? 사용자에게 입력을 받는 사소한 메소드도 테스트를 작성하는 게 좋은가?
// - Scanner을 사용한 메소드는 어떻게 테스트를 작성해야 하는가?

class RacingGameTest {

    private RacingGame racingGame;

    @Test
    void testInputViewGetCarCountFromUser() {
        String mockInput = "3";
        InputView inputView = new InputView(new Scanner(new ByteArrayInputStream(mockInput.getBytes())));
        assertEquals(3, inputView.getCarCountFromUser());
    }

    @Test
    void testInputViewGetRoundCountFromUser() {
        String mockInput = "5";
        InputView inputView = new InputView(new Scanner(new ByteArrayInputStream(mockInput.getBytes())));
        assertEquals(5, inputView.getRoundCountFromUser());
    }
}
