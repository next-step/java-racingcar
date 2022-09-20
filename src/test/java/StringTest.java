import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("String.charAt() 함수 기본 기능 및 파라미터가 인덱스를 벗어나면 StringIndexOutOfBoundsException 가 발생하는지 테스트")
    public void stringCharAtTest(){
        String given = "123";

        assertEquals(given.charAt(0), '1');
        assertEquals(given.charAt(1), '2');
        assertEquals(given.charAt(2), '3');

        assertThatThrownBy(() -> {
            given.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
