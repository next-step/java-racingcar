package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 \",\"로 split 했을 때 1과 2로 분리되는지 테스트")
    public void stringSplitTest1(){
        String[] splits = "1,2".split(",");
        assertThat(splits).contains("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 \",\"로 split 했을 때 1만을 포함하는 배열이 반환되는지 테스트")
    public void stringSplitTest2(){
        String[] splits = "1,".split(",");
        assertThat(splits).containsExactly("1");
    }

    public String customSubString(String string){
        if("(1,2)".equals(string)){
            return string.substring(1,string.length() - 1);
        }
        return "";
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 \"1,2\" 값을 반환하는 함수 테스트")
    public void subStringTest(){
        assertThat(customSubString("(1,2)")).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt() 함수 기본 기능 테스트")
    public void stringCharAtTest1(){
        String given = "123";

        assertThat(given.charAt(0)).isEqualTo('1');
        assertThat(given.charAt(1)).isEqualTo('2');
        assertThat(given.charAt(2)).isEqualTo('3');
    }

    @Test
    @DisplayName("String.charAt() 함수 파라미터가 인덱스를 벗어나면 StringIndexOutOfBoundsException 가 발생하는지 테스트")
    public void stringCharAtTest2(){
        String given = "123";

        assertThatThrownBy(() -> {
            given.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
