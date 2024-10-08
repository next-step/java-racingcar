package study;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("문자열 분리")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 메소드를 활용해 ()을 제거")
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기")
    void charAt() {
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("입력 범위 값이 벗어날 경우 StringIndexOutOfBoundsException 발생")
    void charAt_indexOutOfBoundsException() {
        String data = "abc";
        assertThatThrownBy(() -> data.charAt(data.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    /*스플릿 학습테스트*/
    @Test
    void split_no_if(){
        String[] values = "1".split(",|:");
        assertThat(values).contains("1");
    }

    @Test
    void matters_text(){
        String text = "//.\n1;2;3kk";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
            assertThat(m.group(1)).isEqualTo(".");
            assertThat(m.group(2)).isEqualTo("1;2;3kk");
        }

    }
    @Test
    void matthers_test(){
        String text2= "1:2:5";
        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9,:\\s]");
        assertThat(specialCharPattern.matcher(text2).matches()).isTrue();
        }

        @Test
        void scanner(){
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int number = scanner.nextInt();
        }
}
