package stringcalculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserInputUtilsTest {


    @ParameterizedTest
    @CsvSource(value = {"1 + 2:1 + 2", "1 + 2 - 3 * 4:1 + 2 - 3 * 4"}, delimiter = ':')
    @DisplayName("사용자로부터 받은 입력을 문자열로 저장하는지 테스트.")
    void readUserInput(String KeyBoardInputString, String expectedInputString) {

        //Scanner의 직접적인 키보드 입력은 System.setIn으로 대체해서 테스트한다.
        InputStream in = new ByteArrayInputStream(KeyBoardInputString.getBytes());
        System.setIn(in);

        String userInput = UserInputUtils.readUserInput();

        assertThat(userInput).isEqualTo(expectedInputString);

    }
//
//    read
//        validate
//    split

}