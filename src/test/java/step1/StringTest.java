package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1: 문자열 분리테스트")
    public void req1() {
        String reqString = "1,2";
        String [] sepStrings;
        //string 분리 with 구분자
        sepStrings = reqString.split(",");
        assertThat(sepStrings[0]).isEqualTo("1");
        assertThat(sepStrings[1]).isEqualTo("2");
    }
    @Test
    public void req1_1() {
        String reqString = "1,";
        String [] sepStrings;
        //string 분리 with 구분자
        sepStrings = reqString.split(",");
        assertThat(sepStrings[0]).isEqualTo("1");
    }

    @Test
    @DisplayName("요구사항2: Substring 테스트")
    public void req2() {
        String reqString = "(1,2)";
        String substring1 = reqString.substring(1, 2);
        String substring2 = reqString.substring(reqString.length()-2, reqString.length()-1);
        assertThat(substring1).isEqualTo("1");
        assertThat(substring2).isEqualTo("2");
    }

    @Test
    @DisplayName("요구사항3: chartAt() 메소드 활용")
    public void req3() {
        String reqString = "abc";
        assertThat(reqString.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> reqString.charAt(reqString.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
