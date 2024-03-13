package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String charAt() 테스트")
public class StringCharAtTest {

    @Test
    @DisplayName("index가 주어졌을때 문자열의 index에 있는 문자를 반환한다.")
    public void shouldReturnChar_givenIndex(){
        String input = "abc";
        int index = 0;
        char output = input.charAt(index);
        char expectedOutput = 'a';

        assertThat(output).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("index가 주어졌을때 문자열의 index를 벗어난 경우, StringIndexOfOutputBoundException이 발생한다.")
    public void shouldThrowIndexOutOfBoundsException_givenOutBoundedIndex(){
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                String input = "abc";
                int index = input.length();
                char output = input.charAt(index);
            });
    }
}
