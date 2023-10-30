package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");

        //contains 성공 케이스
        assertThat(result).contains("1"); //배열에 포함되어 있으면 성공(중복도 가능), 순서가 달라도 성공
        assertThat(result).contains("1", "2");
        assertThat(result).contains("2", "1");

        //contains 실패 케이스
//        assertThat(result).contains("3");

        //containsExactly 성공
        assertThat(result).containsExactly("1", "2"); //배열에 포함되어 있으며 순서까지 일치해야 함.
        
        //containsExactly 실패
        assertThat(result).containsExactly("2", "1");
    }
}
