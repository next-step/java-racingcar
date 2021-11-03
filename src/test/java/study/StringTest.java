package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("요구사항1 : 1과 2 분리 테스트")
    void splitContainsTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("요구사항1 : 1만 있는 배열 반환 테스트")
    void splitContainsOnlyTest() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 : ()를 제거한 값 반환하기")
    void substringTest() {
        String input = "(1,2)";
        String result = input.substring(1,input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 : 위치 값 over일 경우 예외 발생 확인")
    void charAtTestIndexOver() {
        String input = "abc";
        int index = input.length() + 1;
        indexOutOfBoundsExceptionCheck(input,index,"String index out of range: \\d+");
    }

    @Test
    @DisplayName("요구사항3 : 위치 값 under일 경우 예외 발생 확인")
    void charAtTestIndexUnder(){
        indexOutOfBoundsExceptionCheck("abc",-1,"String index out of range: -\\d+");
    }

    private void indexOutOfBoundsExceptionCheck(String input, int index, String message){
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(index))
                .withMessageMatching(message);
    }
}