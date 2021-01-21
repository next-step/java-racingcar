package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputHandlerTest {

    @Test
    @DisplayName("잘못된 이름 테스트")
    public void carNameCheckerTest() {
        InputHandler inputHandler = new InputHandler(new Scanner(System.in));
        ArrayList<String> test = new ArrayList<>(Arrays.asList("asd", "aaaaaa"));
        ArrayList<String> test2 = new ArrayList<>(Arrays.asList("asd", "aaa"));
        assertThat(inputHandler.carNameChecker(test)).isFalse();
        assertThat(inputHandler.carNameChecker(test2)).isTrue();
    }

}
