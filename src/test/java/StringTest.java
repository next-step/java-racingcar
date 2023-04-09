import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 및 Exception 발생 학습테스트")
    void charAt() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

    @Test
    @DisplayName("패턴에 해당하는 값 조회")
    void startsWith() {
        String input = "//;\n1,2,3";
        String customDelemiter = "";

        if (input.startsWith("//")) {
            customDelemiter = input.substring(2, input.indexOf("\n"));
            System.out.println("Custom Delemiter : " + customDelemiter);

            input = input.substring(2);
        }

        System.out.println(input + " Custom Delemiter : " + customDelemiter);

    }

    @Test
    @DisplayName("정규표현식")
    void regex() {
        String input = "//;\n1;2,3";
        String customDelemiter = "";

        if (input.startsWith("//")) {
            customDelemiter = input.substring(2, input.indexOf("\n"));
            System.out.println("Custom Delemiter : " + customDelemiter);

            input = input.substring(input.indexOf("\n")+1);
        }

        String[] result = input.split("([,:]|" + customDelemiter + ")");

        for (int i=0; i < result.length; i++) {
            System.out.println("result(" + i +") : " + result[i]);
        }


    }
}
