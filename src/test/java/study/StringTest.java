package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Nested
@DisplayName("String 테스트")
public class StringTest {
    @Test
    void split() {
        //요구사항1 : assertj의 contains, containsExactly 기능으로
        String[] result = "1,2".split( ",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String strText = "(1,2)";
        String[] strArr = {"(", ")"};
        String strRslt = "";

        //입력받은 문자 안에 strArr의 문자와 같은 것이 있으면 substring으로 제외
        for (int i = 0; i < strText.length(); i++) {
            Character cTxt = strText.charAt(i);
            for (int j =0; j < strArr.length; j++) {
                if (strArr[j].equals(Character.toString(cTxt))) {
                    strRslt = strText.substring(j);
                }
            }
        }
        assertThat(strRslt).contains("1,2");
    }


    @Test
    @DisplayName("문자열의 n번째 문자 가져오는 메소드")
    void getChar() {
        String strText = "abc";
        int iIdx = 0;
        String strRslt = Character.toString(strText.charAt(iIdx));
        assertThat(strRslt).contains("a");
    }

    @Test
    @DisplayName("문자열의 n번째 문자가 문자열 길이보다 길 경우 발생하는 오류 테스트")
    void getCharException() {
        String strText = "abc";
        int iIdx = 21;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            String strRslt = Character.toString(strText.charAt(iIdx));
        }).withMessageMatching("Index: " + iIdx +", Size: " + strText.length());
    }
}