package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @DisplayName("split() 사용")
    @Test
    void split(){

        String given = "1,2";

        String[] result = given.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }


    @DisplayName("substring() 사용")
    @Test
    void substring(){
        String given = "(1,2)";

        String result = given.substring(1, given.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

}
