package carracing.presentation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputPresentationTest {
    private InputPresentation inputPresentation;

    public void inAndOutTestHelper(String inputString) {
        inputPresentation = new InputPresentation(
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
        int result = inputPresentation.participates();

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
        int result = inputPresentation.iterations();

        //then
        assertEquals(result, answer);
    }
}