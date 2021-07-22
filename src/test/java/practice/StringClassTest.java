package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringClassTest {

    @DisplayName("콤마(,)로 분리한 문자가 모두 배열에 저장되어야 한다.")
    @Test
    void TEST_split_1(){
        String str = "1,2";
        String[] arr = str.split(",");

        assertThat(arr).contains("1","2");
    }

    @DisplayName("분리할 문자가 없어도 한개의 값이 배열에 저장되어야 한다.")
    @Test
    void TEST_split_2(){
        String str = "1";
        String[] arr = str.split(",");

        assertThat(arr).containsExactly("1");
    }
}
