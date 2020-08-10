package racingcar.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionMessageTest {

    @DisplayName("에러메시지와 데이터를 같이 출력하는 경우")
    @Test
    void messageWithData() {
        String data = "pobi";
        String expected = "[" + data + "]잘못된 입력입니다.";

        ExceptionMessage exceptionMessage = ExceptionMessage.WRONG_CAR_NAMES;

        //when
        String actual = exceptionMessage.buildMessage(data);

        //then
        assertEquals(expected, actual);
    }
}
