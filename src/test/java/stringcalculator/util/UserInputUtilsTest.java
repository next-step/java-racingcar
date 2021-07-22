package stringcalculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "   "})
    @DisplayName("사용자로부터 받은 입력이 공백일 경우, 예외를 던진다.")
    void readUserInput_blank_string(String KeyBoardInputString) {

        //Scanner의 직접적인 키보드 입력은 System.setIn으로 대체해서 테스트한다.
        InputStream in = new ByteArrayInputStream(KeyBoardInputString.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            UserInputUtils.readUserInput();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 사용으로 인해 사용자로부터 받은 입력이 null일 경우, 예외를 던진다.")
    void readUserInput_null() {

        assertThatThrownBy(() -> {
            UserInputUtils.validate(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideSplitStringArr")
    @DisplayName("사용자입력 문자열을 배열로 분할한다.")
    void splitUserInput(String userInput, String[] expectedArray) {

        assertThat(UserInputUtils.splitUserInput(userInput)).isEqualTo(expectedArray);

    }


    private static Stream<Arguments> provideSplitStringArr() {

        String[] arr1 = {"1", "+", "1"};
        String[] arr2 = {"1", "-", "2", "+", "3"};
        String[] arr3 = {"1", "-", "2", "+", "3", "*", "4"};

        return Stream.of(
            Arguments.of("1 + 1", arr1),
            Arguments.of("1 - 2 + 3", arr2),
            Arguments.of("1 - 2 + 3 * 4", arr3)
        );
    }

//
//    read
//        validate
//    split

}