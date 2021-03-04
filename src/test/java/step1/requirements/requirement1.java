package step1.requirements;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class requirement1 {


    //*** String 요구사항 1-1 ***
    @Test
    @DisplayName("1 나오게하는 테스트")
    public void split1Test() {
        String test = "1,2";
        String[] result1 = test.split(",");

        assertThat(test).contains(result1);

    }

    //*** String 요구사항 1-2 ***
    @Test
    @DisplayName("1을 split 해도 1이 나오는지 테스트")
    public void split2Test() {

        String test = "1";
        String[] result = test.split(",");

        assertThat(result).containsExactly(test);
    }

    //*** String 요구사항 2 ***
    @Test
    @DisplayName(" (1,2)를 1,2로 나오게하는 테스트 ")
    public void subStringTest() {
        String test1 = "(1,2)";
        String result1 = test1.substring(1, 4);

        assertThat(result1).isEqualTo("1,2");
    }

    //*** String 요구사항 3 ***
    @Test
    @DisplayName("charAt() 메소드를 이용하여 위치를 벗어났을 때 StringIndexOutOfBoundsException 처리")
    public void charAtTest() {
        String test1 = "abc";
        assertThatThrownBy(() -> {
            test1.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 4");
    }






}
