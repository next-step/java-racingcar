package racing_car.step01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    public void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1").contains("2");
        assertThat(result).containsExactly("1", "2");
        assertThat(result).contains("1", "2");

    }

    @Test
    public void substring() {
        String str = "(1,2)";
        String result = str.substring(str.indexOf("(")+1, str.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
        assertThat(result).contains("1");

    }

    @Test
    @DisplayName("String 의 charAt() 메소드를 활용해서 특정 위치의 문자 가져오기  ")
    public void charAt(){
        String text = "abc";
        assertThat(text.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("String 의 charAt() 메소드로 특정 위치의 문자를 가져올 때 실패 테스트 ")
    public void charAtFail(){
        String text = "abc";
        assertThatThrownBy(() ->{
            text.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);


    }
}
