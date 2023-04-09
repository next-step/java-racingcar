package carracing.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {
    private InputView inputView;

    public void inAndOutTestHelper(String inputString) {
        inputView = new InputView(
                new BufferedInputStream(new ByteArrayInputStream(inputString.getBytes())),
                System.out
        );
    }

    @DisplayName("경기에 참가하는 차량의 수를 입력받는다")
    @Test
    public void participate() {
        //given
        String input = "5";
        int answer = 5;

        //when
        inAndOutTestHelper(input);
        int result = inputView.participate();

        //then
        assertEquals(result, answer);
    }

    @DisplayName("경기를 반복회는 횟수를 입력받는다")
    @Test
    public void iteration() {
        //given
        String input = "7";
        int answer = 7;

        //when
        inAndOutTestHelper(input);
        int result = inputView.participate();

        //then
        assertEquals(result, answer);
    }
}