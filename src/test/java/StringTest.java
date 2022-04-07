import org.assertj.core.api.Assertions;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("요구사항1. 잘 분리되는지 확인하는 학습 테스트")
    @Test
    void split(){
        String numbers = "1,2";
        String[] splitedNumbers = numbers.split(",");
        assertThat(splitedNumbers).contains("1");
        assertThat(splitedNumbers).containsExactly("1","2");
    }

    @DisplayName("요구사항1. String이 하나일때 하나만 정상반환되는지 확인하는 테스트")
    @Test
    void splitOneString(){
        String number = "1";
        String[] splitedNumber = number.split(",");
        assertThat(splitedNumber).contains("1");
    }

    @DisplayName("요구사항2. ()을 제거 확인 테스트")
    @Test
    void bracketRemoveTest(){
        String numbersWithBracket = "(1,2)";
        assertThat(Bracket.remove(numbersWithBracket)).isEqualTo("1,2");
    }

    @DisplayName("요구사항3. charAt() 메소드 테스트")
    @Test
    void chatAtTest(){
        String chatString = "test";
        assertThat(chatString.charAt(3)).isEqualTo('t');
    }

    @DisplayName("요구사항3. charAt() 메소드 exception 테스트1")
    @Test
    void chatAtExceptionTest1(){
        assertThatThrownBy(() -> "test".charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index");
    }

    @DisplayName("요구사항3. charAt() 메소드 exception 테스트2")
    @Test
    void chatAtExceptionTest2(){
        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->  "abc".charAt(4))
                .withMessageMatching("String index out of range: 4");
    }
}
