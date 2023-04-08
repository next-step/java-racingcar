package carracing.race.ui;

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
        inAndOutTestHelper(input);
        //when
        int result = inputView.participate();
        //then
        assertEquals(result, answer);
    }

    @Test
    public void testSystemOutPrintln() {
        // 출력하려는 문자열을 작성합니다.
        String testString = "Hello, world!";
        // 문자열을 출력합니다.
        System.out.print(testString);
        inputView.iterations();
        // SystemOutRule 객체를 사용하여 출력된 문자열을 가져옵니다.
        //String outputString = systemOutRule.getLog();
        // 예상되는 출력 문자열과 일치하는지 확인합니다.
        //assertEquals(testString, outputString);
    }
}