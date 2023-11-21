package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void 요구사항1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2"); // 순서보장
    }

    @Test
    void 요구사항2() {
        String myString = "(1,2)";
        String expectedResult = "1,2";

        String result = myString.substring(1, 4);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("String의 length를 넘어서는 index를 참조하면 StringIndexOutOfBoundsException 발생한다")
    void 요구사항3() {
        String myString = "abc";
        int outOfIndex = 5;

        assertThatThrownBy(() -> {
            myString.charAt(outOfIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + outOfIndex);
    }

    @Test
    void 연속된_delimiter를_split하면_어떻게되는가() {
        String test = ",,1";
        for (String str : test.split(",")) {
            System.out.println(str);
        }
    }

    @Test
    void Matcher_Pattern는_어떻게쓰는가(){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher("//;\n1;2;3");
        if (m.find()) {
            String customDelimiter = m.group(1);
            System.out.println(customDelimiter);
            String[] tokens= m.group(2).split(customDelimiter);
            System.out.println(tokens.length);
        }
    }
}
